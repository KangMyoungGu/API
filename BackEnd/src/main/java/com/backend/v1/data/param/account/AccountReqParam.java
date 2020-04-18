package com.backend.v1.data.param.account;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AccountReqParam {
    private String accountId;
    private String accountName;
    private String accountPw;
    private String accountAddress;
    private String accountContactNumber;
    private String accountEmail;
    private String accountBirth;
}
