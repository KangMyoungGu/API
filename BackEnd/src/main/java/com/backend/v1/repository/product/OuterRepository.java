package com.backend.v1.repository.product;

import java.util.List;

import com.backend.v1.data.dto.product.OuterDto;
import com.backend.v1.data.param.product.OuterListReqParam;

public interface OuterRepository {

	List<OuterDto> selectOuterLists(OuterListReqParam param);

	List<OuterDto> selectOuterBestList(OuterListReqParam param);

}
