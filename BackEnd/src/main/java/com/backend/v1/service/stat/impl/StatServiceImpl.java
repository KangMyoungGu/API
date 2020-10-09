package com.backend.v1.service.stat.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.v1.data.dto.stat.CountOfEachProductDto;
import com.backend.v1.repository.stat.impl.StatRepository;
import com.backend.v1.service.stat.StatService;

@Service
public class StatServiceImpl implements StatService {
	
	@Autowired StatRepository statRepository;
	
	@Override
	public List<CountOfEachProductDto> getCountOfEachProduct() {
		return statRepository.getCountOfEachProduct();
	}

}
