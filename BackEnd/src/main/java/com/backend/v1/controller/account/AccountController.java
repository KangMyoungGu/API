package com.backend.v1.controller.account;

import com.backend.v1.ApiHeader;
import com.backend.v1.Exception.ParameterException;
import com.backend.v1.RtCode;
import com.backend.v1.adapter.AuthAdapter;
import com.backend.v1.common.util.RedisUtil;
import com.backend.v1.common.util.TokenUtil;
import com.backend.v1.data.dto.RtDto;
import com.backend.v1.data.dto.product.OuterDto;
import com.backend.v1.data.param.account.AccountReqParam;
import com.backend.v1.data.param.product.OuterListReqParam;
import com.backend.v1.service.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value="/v1/api/account")
@CrossOrigin
public class AccountController {

    @Autowired private AccountService accountService;

    @RequestMapping(value="/create", method = RequestMethod.POST)
    public @ResponseBody RtDto createAccount(@RequestBody AccountReqParam accountReqParam) {
        RtDto rtDto = new RtDto();
        try{
            accountService.checkValidation4Account(accountReqParam);
            accountService.createAccount(accountReqParam);
            rtDto.setRtCode(RtCode.RT_SUCCESS.getErrorCode());
            rtDto.setRtMsg(RtCode.RT_SUCCESS.getErrorMessage());
        }catch (ParameterException e){
            rtDto.setRtCode(RtCode.RT_PARAMETER_ERROR.getErrorCode());
            rtDto.setRtMsg(RtCode.RT_PARAMETER_ERROR.getErrorMessage());
        }catch (Exception e){
            rtDto.setRtCode(RtCode.RT_INTERNAL_ERROR.getErrorCode());
            rtDto.setRtMsg(RtCode.RT_INTERNAL_ERROR.getErrorMessage());
        }
        return rtDto;
    }

}
