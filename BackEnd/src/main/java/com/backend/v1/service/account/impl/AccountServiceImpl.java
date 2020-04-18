package com.backend.v1.service.account.impl;

import com.backend.v1.data.dto.account.AccountDto;
import com.backend.v1.data.param.account.AccountReqParam;
import com.backend.v1.data.param.account.UserLoginReqParam;
import com.backend.v1.repository.account.AccountRepository;
import com.backend.v1.service.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired private AccountRepository accountRepository;

    public void createAccount(AccountReqParam param){
        accountRepository.createAccount(param);
    }

    @Override
    public AccountDto getAccount(UserLoginReqParam param) {
        return accountRepository.getAccount(param);
    }
}
