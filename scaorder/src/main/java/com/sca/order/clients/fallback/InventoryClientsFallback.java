package com.sca.order.clients.fallback;

import com.alibaba.fastjson.JSONObject;
import com.sca.module.inventory.ReductionInventory;
import com.sca.order.clients.InventoryClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component(value = "inventoryClientsFallback")
public class InventoryClientsFallback implements InventoryClients {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public boolean reductionInventory (ReductionInventory inventory) {
		logger.error("减库存出错了:" + JSONObject.toJSONString(inventory));
		return false;
	}
//	@Override
//	public Map<String, Object> inventoryReduction () {
//		System.out.println("调用减库存服务失败，记录日志");
//		Map<String,Object> map = new HashMap<>();
//		map.put("error","订单创建时减库存失败");
//		return map;
//	}
}
