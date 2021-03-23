package com.sca.order.service;


import com.sca.module.order.OrderInfo;

import java.util.Map;

public interface OrderService {
	
	public Map<String,Object> createOrder();
	
	public String createOrder(OrderInfo info);
}
