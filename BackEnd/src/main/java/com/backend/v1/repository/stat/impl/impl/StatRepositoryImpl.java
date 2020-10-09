package com.backend.v1.repository.stat.impl.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.backend.v1.common.util.DBUtil;
import com.backend.v1.data.dto.stat.CountOfEachProductDto;
import com.backend.v1.repository.stat.impl.StatRepository;

@Repository
public class StatRepositoryImpl implements StatRepository {
	
	private @Autowired @Qualifier("sqlSession") SqlSession sqlSession;
	
	@Override
	public List<CountOfEachProductDto> getCountOfEachProduct() {
		return sqlSession.selectList("com.backend.v1.repository.stat.StatRepository.getCountOfEachProduct");
//		return sqlSession.selectList(".getCountOfEachProduct");
	}

}
