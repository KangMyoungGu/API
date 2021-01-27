package com.backend.v1.controller.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.v1.RtCode;
import com.backend.v1.data.domain.account.RequestUser;
import com.backend.v1.data.dto.RtClass;
import com.backend.v1.data.dto.order.OrderDto.OrderDetailDto;
import com.backend.v1.data.param.order.OrderParam.OrderALLReqParam;
import com.backend.v1.exception.ApiException;
import com.backend.v1.facade.order.OrderFacade;
import com.backend.v1.service.order.OrderService;

@RestController
@RequestMapping(value = "/v1/api/order")
@CrossOrigin
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	//@Autowired
	//private OrderFacade orderFacade;

	/**
	 * @apiNote 나의 주문내역 조회 API
	 */
	@Secured("ROLE_USER")
	@GetMapping("/mypage/order_list")
	public RtClass<List<OrderDetailDto>> getMyOrderList(@AuthenticationPrincipal RequestUser requestUser) {

		RtClass<List<OrderDetailDto>> rt = new RtClass<List<OrderDetailDto>>();
		rt.setRtCode(RtCode.RT_SUCCESS.getErrorCode());
		rt.setRtMsg(RtCode.RT_SUCCESS.getErrorMessage());

		try {
			List<OrderDetailDto> orderList = orderService.getListBy(requestUser.getUserId());
			rt.setData(orderList);
		} catch (Exception e) {
			throw new ApiException(RtCode.RT_INTERNAL_ERROR);
		}

		return rt;
	}

	/**
	 * @apiNote 주문등록 API
	 */
	@SuppressWarnings("rawtypes")
	@Secured("ROLE_USER")
	@PostMapping("")
	public RtClass postOrder(@RequestBody OrderALLReqParam param, @AuthenticationPrincipal RequestUser requestUser) {

		RtClass rt = new RtClass();
		rt.setRtCode(RtCode.RT_SUCCESS.getErrorCode());
		rt.setRtMsg(RtCode.RT_SUCCESS.getErrorMessage());
		
		try {
			orderService.postOrder(param, requestUser.getUserId());
		} catch(Exception e) {
			throw new ApiException(RtCode.RT_INTERNAL_ERROR);
		}

		return rt;
	}
}
