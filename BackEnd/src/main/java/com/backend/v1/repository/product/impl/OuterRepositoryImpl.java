package com.backend.v1.repository.product.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.backend.v1.data.dto.product.OuterDto;
import com.backend.v1.data.param.product.OuterListReqParam;
import com.backend.v1.repository.product.OuterRepository;

@Repository
public class OuterRepositoryImpl implements OuterRepository{
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<OuterDto> selectOuterLists() {

		return sqlSession.selectList("outerRepository.selectOuterList");
	}

	@Override
	public List<OuterDto> selectOuterBestList(OuterListReqParam param) {
		return sqlSession.selectList("outerRepository.selectOuterBestList", param);
	}

}
