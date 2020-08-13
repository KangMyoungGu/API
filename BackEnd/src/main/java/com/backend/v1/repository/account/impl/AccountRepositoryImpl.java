package com.backend.v1.repository.account.impl;

import com.backend.v1.data.dto.account.AccountDto;
import com.backend.v1.data.param.account.AccountReqParam;
import com.backend.v1.data.param.account.UserLoginReqParam;
import com.backend.v1.repository.account.AccountRepository;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class AccountRepositoryImpl implements AccountRepository {
    @Autowired
    @Qualifier("sqlSession")
    private SqlSession sqlSession;

    @Autowired
    @Qualifier("secondSqlSession")
    private SqlSession secondarySqlSession;

    @Override
    public void createAccount(AccountReqParam param) {
        sqlSession.insert("accountRepository.createAccount", param);
    }
    @Override
    public AccountDto getAccount(UserLoginReqParam param){
        return sqlSession.selectOne("accountRepository.getAccount", param);
    }
}
