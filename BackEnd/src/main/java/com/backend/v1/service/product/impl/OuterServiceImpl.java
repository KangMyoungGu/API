package com.backend.v1.service.product.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.v1.common.util.ImageUtil;
import com.backend.v1.data.dto.product.OuterDto;
import com.backend.v1.data.param.product.OuterListReqParam;
import com.backend.v1.repository.product.OuterRepository;
import com.backend.v1.service.product.OuterService;

@Service
public class OuterServiceImpl implements OuterService{

	@Autowired private OuterRepository outerReposiroty;
	@Autowired private ImageUtil imageUtil;
	
	@Override
	public List<OuterDto> selectOuterLists() throws IOException {
		return outerReposiroty.selectOuterLists();
	}

	@Override
	public List<OuterDto> selectOuterBestList(OuterListReqParam param) throws IOException {
		return outerReposiroty.selectOuterBestList(param);
	}

}
