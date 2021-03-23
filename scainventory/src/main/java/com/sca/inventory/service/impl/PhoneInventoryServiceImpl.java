package com.sca.inventory.service.impl;

import com.sca.inventory.dao.PhoneInventoryMapper;
import com.sca.inventory.service.PhoneInventoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class PhoneInventoryServiceImpl implements PhoneInventoryService {
	@Resource
	private PhoneInventoryMapper phoneInventoryMapper;
	
	@Override
	@Transactional
	public boolean reduction (String inventoryId, int num) {
		//实际应先判断id是否有对应的数据
		return phoneInventoryMapper.updateByReductionInventory(inventoryId, num) > 0;
	}
}
