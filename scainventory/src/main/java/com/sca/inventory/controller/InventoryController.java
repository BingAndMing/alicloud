package com.sca.inventory.controller;

import com.sca.inventory.service.PhoneInventoryService;
import com.sca.module.inventory.ReductionInventory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/Inventory")
public class InventoryController {
	@Value("${server.port}")
	private String port;
	@Resource
	private PhoneInventoryService phoneInventoryService;
	
//	@GetMapping(value = "/inventoryReduction.do")
//	public Map<String, Object> inventoryReduction () {
//		System.out.println("库存减1");
//		Map<String, Object> map = new HashMap<>();
//		map.put("state", 200);
//		map.put("data", "库存减1");
//		map.put("port", port);
//		return map;
//	}
	
	@RequestMapping(value = "/reductionInventory.do", method = RequestMethod.POST, consumes = "application/json")
	public boolean reductionInventory(@RequestBody ReductionInventory inventory){
		System.out.println("调用减库存接口，商品id ： " + inventory.getId() + ";减库存数量： " + inventory.getNum());
		return phoneInventoryService.reduction(inventory.getId(),inventory.getNum());
//		throw new RuntimeException("报错");
	}
}
