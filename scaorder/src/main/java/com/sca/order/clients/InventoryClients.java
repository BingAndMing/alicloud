package com.sca.order.clients;

import com.sca.module.inventory.ReductionInventory;
import com.sca.order.clients.fallback.InventoryClientsFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(value = "sca-inventory",fallback = InventoryClientsFallback.class)
public interface InventoryClients {
//	@GetMapping(value = "/Inventory/inventoryReduction.do")
//	public Map<String,Object> inventoryReduction();
	
	@RequestMapping(value = "/Inventory/reductionInventory.do", method= RequestMethod.POST, consumes = "application/json")
	public boolean reductionInventory(@RequestBody ReductionInventory inventory);
}
