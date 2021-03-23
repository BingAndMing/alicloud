package com.sca.order.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.sca.module.inventory.ReductionInventory;
import com.sca.module.order.OrderInfo;
import com.sca.order.clients.CommonClients;
import com.sca.order.clients.InventoryClients;
import com.sca.order.dao.OrderRecordMapper;
import com.sca.order.model.OrderRecord;
import com.sca.order.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

@SuppressWarnings("all")
@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private InventoryClients inventoryClients;
	@Autowired
	private CommonClients commonClients;
	@Autowired
	private OrderRecordMapper orderRecordMapper;
	
	@Override
	@GlobalTransactional
	public Map<String, Object> createOrder () {
//		System.out.println("创建订单");
//		Map<String,Object> map = inventoryClients.inventoryReduction();
//		if(map != null && !map.isEmpty()){
//			map.put("order", UUID.randomUUID());
//		}
//		return map;
		return null;
	}
	
	@Override
	@GlobalTransactional
	public String createOrder (OrderInfo info) {
		String userJsonStr = commonClients.getUserInfoByUserId(info.getUserId());
		if(StringUtils.isBlank(userJsonStr)){
			throw new RuntimeException("用户不存在");
		}
		JSONObject userObj = JSONObject.parseObject(userJsonStr);
		if(userObj == null || StringUtils.isBlank(userObj.getString("id"))){
			throw new RuntimeException("用户不存在");
		}
		OrderRecord orderRecord = new OrderRecord();
		orderRecord.setId(StringUtils.replace(UUID.randomUUID().toString(),"-",""));
		//一般业务上有自己的业务规则生成编号
		orderRecord.setBusinessNo(StringUtils.replace(UUID.randomUUID().toString(),"-",""));
		orderRecord.setUserId(info.getUserId());
		//校验省略
		orderRecord.setCommodityId(info.getCommodityId());
		orderRecord.setCreateTime(new Date());
		orderRecordMapper.insert(orderRecord);
		ReductionInventory inventory = new ReductionInventory();
		inventory.setId(info.getCommodityId());
		inventory.setNum(info.getAmount());
		inventoryClients.reductionInventory(inventory);
		return "success";
	}
}
