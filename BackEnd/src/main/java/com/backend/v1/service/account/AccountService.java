package com.backend.v1.service.account;

import com.backend.v1.data.dto.account.AccountDto;
import com.backend.v1.data.param.account.AccountReqParam;
import com.backend.v1.data.param.account.UserLoginReqParam;

public interface AccountService {
    void createAccount(AccountReqParam param);
    AccountDto getAccount(UserLoginReqParam param);
    void checkValidation4Account(AccountReqParam param);
    void checkValidation4Login(UserLoginReqParam param);
}
