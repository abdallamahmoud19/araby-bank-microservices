package com.araby.accounts.mapper;

import com.araby.accounts.dto.AccountsDto;
import com.araby.accounts.entity.Accounts;

public class AccountsMapper {

    public static AccountsDto mapToAccountsDto(Accounts accounts) {
        AccountsDto accountsDto = new AccountsDto();
        accountsDto.setAccountNumber(accounts.getAccountNumber());
        accountsDto.setAccountType(accounts.getAccountType());
        accountsDto.setBranchAddress(accounts.getBranchAddress());
        return accountsDto;
    }

    public static Accounts mapToAccounts(AccountsDto accountsDto, Accounts accounts) {

        if (accountsDto.getAccountType() != null) {
            accounts.setAccountType(accountsDto.getAccountType());
        }

        if (accountsDto.getBranchAddress() != null) {
            accounts.setBranchAddress(accountsDto.getBranchAddress());
        }
        return accounts;
    }
}
