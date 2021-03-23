package com.sca.order.controller;

import com.sca.module.order.OrderInfo;
import com.sca.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/ScaOrder")
public class ScaOrderController {
	@Autowired
	private OrderService orderService;
	
	@PostMapping(value = "/createOrder.do",consumes = "application/json")
	public String createOrder(@RequestBody OrderInfo info){
//		return "success";
		try {
			return orderService.createOrder(info);
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
}
