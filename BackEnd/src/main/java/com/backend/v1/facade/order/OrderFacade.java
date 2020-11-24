package com.backend.v1.facade.order;

import com.backend.v1.data.param.order.OrderParam.OrderALLReqParam;

public interface OrderFacade {

	void postOrder(OrderALLReqParam param, String userId);

}
