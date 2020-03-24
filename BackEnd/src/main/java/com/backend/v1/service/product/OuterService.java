package com.backend.v1.service.product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.backend.v1.data.dto.product.OuterDto;
import com.backend.v1.data.param.product.OuterListReqParam;

public interface OuterService {

	List<OuterDto> selectOuterLists(OuterListReqParam param) throws IOException;

}
