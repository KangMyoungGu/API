package com.backend.v1.controller.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.v1.data.domain.account.RequestUser;
import com.backend.v1.data.dto.RtClass;
import com.backend.v1.data.dto.order.OrderDto.OrderListDto;
import com.backend.v1.service.order.OrderService;

@RestController
@RequestMapping(value="/v1/api/user")
@CrossOrigin
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/mypage/order_list")
	public RtClass<List<OrderListDto>> getMyOrderList(@AuthenticationPrincipal RequestUser user){
		List<OrderListDto> orderList = orderService.getListBy(user.getUserId());
		return new RtClass<>();
	}
}
