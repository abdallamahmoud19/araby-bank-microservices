package com.araby.accounts.mapper;

import com.araby.accounts.dto.CustomerDto;
import com.araby.accounts.entity.Customer;

public class CustomerMapper {

    public static CustomerDto mapToCustomerDto(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName(customer.getName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setMobileNumber(customer.getMobileNumber());
        return customerDto;
    }

    public static Customer mapToCustomer(CustomerDto customerDto, Customer customer) {

        if (customerDto.getName() != null) {
            customer.setName(customerDto.getName());
        }

        if (customerDto.getEmail() != null) {
            customer.setEmail(customerDto.getEmail());
        }

        if (customerDto.getMobileNumber() != null) {
            customer.setMobileNumber(customerDto.getMobileNumber());
        }

        return customer;
    }
}
