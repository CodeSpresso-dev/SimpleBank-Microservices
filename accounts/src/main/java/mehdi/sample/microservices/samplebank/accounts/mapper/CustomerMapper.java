package mehdi.sample.microservices.samplebank.accounts.mapper;

import mehdi.sample.microservices.samplebank.accounts.dto.CustomerDto;
import mehdi.sample.microservices.samplebank.accounts.entity.Customer;
import org.springframework.beans.BeanUtils;

public class CustomerMapper {
    public static CustomerDto mapToCustomerDto(Customer customer, CustomerDto customerDto) {
//        customerDto.setEmail(customer.getEmail());
//        customerDto.setName(customer.getName());
//        customerDto.setMobileNumber(customer.getMobileNumber());
        BeanUtils.copyProperties(customer, customerDto);
        return customerDto;
    }

    public static Customer mapToCustomer(CustomerDto customerDto, Customer customer) {
//        customer.setEmail(customerDto.getEmail());
//        customer.setName(customerDto.getName());
//        customer.setMobileNumber(customerDto.getMobileNumber());
        BeanUtils.copyProperties(customerDto, customer);
        return customer;
    }
}
