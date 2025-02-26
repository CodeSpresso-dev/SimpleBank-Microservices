package mehdi.sample.microservices.samplebank.accounts.service.impl;

import lombok.AllArgsConstructor;
import mehdi.sample.microservices.samplebank.accounts.constants.AccountsConstants;
import mehdi.sample.microservices.samplebank.accounts.dto.AccountsDto;
import mehdi.sample.microservices.samplebank.accounts.dto.CustomerDto;
import mehdi.sample.microservices.samplebank.accounts.entity.Accounts;
import mehdi.sample.microservices.samplebank.accounts.entity.Customer;
import mehdi.sample.microservices.samplebank.accounts.exception.CustomerAlreadyExistsException;
import mehdi.sample.microservices.samplebank.accounts.exception.ResourceNotFoundException;
import mehdi.sample.microservices.samplebank.accounts.mapper.AccountsMapper;
import mehdi.sample.microservices.samplebank.accounts.mapper.CustomerMapper;
import mehdi.sample.microservices.samplebank.accounts.repository.AccountsRepository;
import mehdi.sample.microservices.samplebank.accounts.repository.CustomerRepository;
import mehdi.sample.microservices.samplebank.accounts.service.IAccountsService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountsServiceImpl implements IAccountsService {

    private final AccountsRepository accountsRepository;
    private final CustomerRepository customerRepository;

    /**
     * @param customerDto
     */
    @Override
    public void createAccount(CustomerDto customerDto) {

        Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());

        Optional<Customer> customerExists = customerRepository.findByMobileNumber(customer.getMobileNumber());

        if (customerExists.isPresent()) {
            throw new CustomerAlreadyExistsException("Customer already exists with given mobile number " + customerDto.getMobileNumber());
        }

        Customer savedCustomer = customerRepository.save(customer);

        accountsRepository.save(createNewAccount(savedCustomer));
    }

    /**
     * @param mobileNumber
     * @return fetch account details based on given mobile number
     */
    @Override
    public CustomerDto fetchAccountDetailsByMobileNumber(String mobileNumber) {
        Customer savedCustomer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobile number", mobileNumber)
        );
        Accounts savedAccounts = accountsRepository.findByCustomerId(savedCustomer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "customer id", savedCustomer.getCustomerId().toString())
        );

        CustomerDto customerDto = CustomerMapper.mapToCustomerDto(savedCustomer, new CustomerDto());
        AccountsDto accountsDto = AccountsMapper.mapToAccountsDto(savedAccounts, new AccountsDto());
        customerDto.setAccountsDto(accountsDto);

        return customerDto;
    }

    /**
     *
     * @param customerDto
     * @return
     */

    @Override
    public boolean updateAccount(CustomerDto customerDto) {
        boolean isUpdated = false;
        AccountsDto recivedAccountsDto = customerDto.getAccountsDto();
        Accounts savedAccounts = accountsRepository.findById(recivedAccountsDto.getAccountNumber()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "account id", recivedAccountsDto.getAccountNumber().toString())
        );
        Accounts accountsToUpdate = AccountsMapper.mapToAccounts(recivedAccountsDto, savedAccounts);
        accountsRepository.save(accountsToUpdate);

        Customer savedCustomer = customerRepository.findById(accountsToUpdate.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "customer id", accountsToUpdate.getCustomerId().toString())
        );
        Customer customerToSave = CustomerMapper.mapToCustomer(customerDto, savedCustomer);
        customerRepository.save(customerToSave);

        isUpdated=true;

        return isUpdated;
    }

    /**
     *
     * @param mobileNumber
     * @return boolean indicating if delete of account details is successful or not
     */
    @Override
    public boolean deleteAccount(String mobileNumber) {
        Customer savedCustomer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobile number", mobileNumber)
        );
        accountsRepository.deleteByCustomerId(savedCustomer.getCustomerId());
        customerRepository.deleteById(savedCustomer.getCustomerId());
        return true;
    }

    /**
     * @param savedCustomer
     * @return The new account detail
     */
    private Accounts createNewAccount(Customer savedCustomer) {
        Accounts newAccounts = new Accounts();
        newAccounts.setCustomerId(savedCustomer.getCustomerId());
        long accountNumber = 1000000000L + new Random().nextInt(900000000);
        newAccounts.setAccountNumber(accountNumber);
        newAccounts.setAccountType(AccountsConstants.SAVINGS);
        newAccounts.setBranchAddress(AccountsConstants.ADDRESS);

        return newAccounts;
    }
}
