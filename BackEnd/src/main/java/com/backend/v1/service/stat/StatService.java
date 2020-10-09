package com.backend.v1.service.stat;

import java.util.List;

import com.backend.v1.data.dto.stat.CountOfEachProductDto;

public interface StatService {
	List<CountOfEachProductDto> getCountOfEachProduct();
}
