package com.backend.v1.data.dto.account;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@RequiredArgsConstructor
public class AccountDto {
    private int ACCOUNT_AUTO_ID;
    private String ACCOUNT_ID;
    private String ACCOUNT_NAME;
    private String ACCOUNT_PW;
    private String ACCOUNT_ADDRESS;
    private String ACCOUNT_CONTACT_NUMBER;
    private String ACCOUNT_EMAIL;
    private String ACCOUNT_BIRTH;
    private String ACCOUNT_REG_DT;
    private String ACCOUNT_MOD_DT;
}
