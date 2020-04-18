package com.backend.v1.data.dto;

import java.util.ArrayList;
import java.util.List;

import com.backend.v1.data.domain.account.SessionDomain;
import com.backend.v1.data.dto.product.OuterDto;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class RtDto<T> {
	String rtCode;
	String rtMsg;

	T rtData;
	
	List<OuterDto> list;
}
