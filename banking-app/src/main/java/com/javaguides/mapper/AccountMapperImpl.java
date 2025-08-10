package com.javaguides.mapper;

import org.springframework.stereotype.Component;

import com.javaguides.dto.AccountDto;
import com.javaguides.entity.Account;

@Component
public class AccountMapperImpl implements AccountMapper {

    @Override
    public Account toEnity(AccountDto accountDto) {
        if (accountDto == null) {
            return null;
        }

        Account account =  new Account();
        account.setBalance(accountDto.getBalance());
        account.setAccountHolderName(accountDto.getAccountHolderName());

        return account;
    }

    @Override
    public AccountDto toDTO(Account account) {
        if (account == null) {
             return null;
        }

        AccountDto accountDTO = new AccountDto(null, null, 0);
        accountDTO.setBalance(account.getBalance());
        accountDTO.setAccountHolderName(account.getAccountHolderName());

        return accountDTO;

    }
}
