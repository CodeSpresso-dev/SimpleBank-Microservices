package mehdi.sample.microservices.samplebank.accounts.service;

import mehdi.sample.microservices.samplebank.accounts.dto.CustomerDto;

public interface IAccountsService {
    /**
     *
     * @param customerDto
     */
    void createAccount(CustomerDto customerDto);

    /**
     *
     * @param mobileNumber
     * @return fetch account details based on mobile number given
     */
    CustomerDto fetchAccountDetailsByMobileNumber(String mobileNumber);

    /**
     *
     * @param customerDto
     * @return boolean indicating if the update of account details is successful or not
     */
    boolean updateAccount(CustomerDto customerDto);

    /**
     *
     * @param mobileNumber
     * @return boolean indicating if delete of account details is successful or not
     */
    boolean deleteAccount(String mobileNumber);
}
