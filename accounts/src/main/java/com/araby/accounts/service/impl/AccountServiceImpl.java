package com.araby.accounts.service.impl;

import com.araby.accounts.constants.AccountsConstants;
import com.araby.accounts.dto.AccountsDto;
import com.araby.accounts.dto.CustomerDto;
import com.araby.accounts.entity.Accounts;
import com.araby.accounts.entity.Customer;
import com.araby.accounts.exception.CustomerAlreadyExistsException;
import com.araby.accounts.exception.ResourceNotFoundException;
import com.araby.accounts.mapper.AccountsMapper;
import com.araby.accounts.mapper.CustomerMapper;
import com.araby.accounts.repository.AccountsRepository;
import com.araby.accounts.repository.CustomerRepository;
import com.araby.accounts.service.IAccountsService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountsService {

     private final CustomerRepository customerRepository;
     private final AccountsRepository accountsRepository;

    @Override
    public void createAccount(CustomerDto customerDto) {
        Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());
        Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(customerDto.getMobileNumber());
        if (optionalCustomer.isPresent()) {
            throw new CustomerAlreadyExistsException(
                    "Customer already registered with given mobileNumber "
                    + customerDto.getMobileNumber());
        }
        Customer savedCustomer = customerRepository.save(customer);
        accountsRepository.save(createNewAccount(savedCustomer));
    }


    private Accounts createNewAccount(Customer customer) {
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);
        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);

        return newAccount;
    }


    @Override
    public CustomerDto fetchAccount(String mobileNumber) {

        Customer customer=   customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                ()->new ResourceNotFoundException(
                        "Customer",
                        "mobileNumber",
                        mobileNumber));

        Accounts account = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                ()->new ResourceNotFoundException(
                        "Account",
                        "customerId",
                        mobileNumber)
        );

        CustomerDto customerDto = CustomerMapper.mapToCustomerDto(customer);
        customerDto.setAccountsDto(AccountsMapper.mapToAccountsDto(account));

        return customerDto;
    }

    @Override
    @Transactional
    public boolean updateAccount(CustomerDto customerDto) {


        AccountsDto accountsDto = customerDto.getAccountsDto();

        if (accountsDto == null) {
            return false;
        }

        Accounts accounts = accountsRepository.findById(
                accountsDto.getAccountNumber()
        ).orElseThrow(
                () -> new ResourceNotFoundException(
                        "Account",
                        "AccountNumber",
                        accountsDto.getAccountNumber().toString()
                )
        );

        AccountsMapper.mapToAccounts(accountsDto, accounts);

        Long customerId = accounts.getCustomerId();

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(
                        () -> new ResourceNotFoundException(
                                "Customer",
                                "CustomerID",
                                customerId.toString()
                        )
                );

        CustomerMapper.mapToCustomer(customerDto, customer);

        return true;
    }

    @Override
    public boolean deleteAccount(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException(
                        "Customer",
                        "mobileNumber",
                        mobileNumber));

        accountsRepository.deleteByCustomerId(customer.getCustomerId());
        customerRepository.deleteById(customer.getCustomerId());
        return true;
    }


}
