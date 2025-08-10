package com.javaguides.mapper;

import com.javaguides.dto.AccountDto;
import com.javaguides.entity.Account;

public interface AccountMapper {

    Account toEnity(AccountDto accountDTO);

    AccountDto toDTO(Account account);

}
