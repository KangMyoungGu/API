package com.backend.v1.repository.stat.impl;

import java.util.List;

import com.backend.v1.data.dto.stat.CountOfEachProductDto;

public interface StatRepository {
	List<CountOfEachProductDto> getCountOfEachProduct();
}
