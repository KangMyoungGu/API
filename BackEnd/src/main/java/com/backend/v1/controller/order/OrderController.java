package com.backend.v1.controller.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.v1.RtCode;
import com.backend.v1.data.domain.account.RequestUser;
import com.backend.v1.data.dto.RtClass;
import com.backend.v1.data.dto.order.OrderDto.OrderListDto;
import com.backend.v1.exception.ApiException;
import com.backend.v1.service.order.OrderService;

@RestController
@RequestMapping(value = "/v1/api/order")
@CrossOrigin
public class OrderController {

	@Autowired
	private OrderService orderService;

	/**
	 * @apiNote 나의 주문내역 조회 API
	 */
	@Secured("ROLE_USER")
	@GetMapping("/mypage/order_list")
	public RtClass<List<OrderListDto>> getMyOrderList(@AuthenticationPrincipal RequestUser user) {

		RtClass<List<OrderListDto>> rt = new RtClass<List<OrderListDto>>();
		rt.setRtCode(RtCode.RT_SUCCESS.getErrorCode());
		rt.setRtMsg(RtCode.RT_SUCCESS.getErrorMessage());

		try {
			List<OrderListDto> orderList = orderService.getListBy(user.getUserId());
			rt.setData(orderList);
		} catch (Exception e) {
			throw new ApiException(RtCode.RT_INTERNAL_ERROR);
		}

		return rt;
	}
}
