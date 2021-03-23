package com.sca.inventory.dao;

import com.sca.inventory.model.PhoneInventory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PhoneInventoryMapper {
	int deleteByPrimaryKey(String id);

	int insert(PhoneInventory record);

	int insertSelective(PhoneInventory record);

	PhoneInventory selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(PhoneInventory record);

	int updateByPrimaryKey(PhoneInventory record);

	int updateByReductionInventory(@Param("id") String id, @Param("num") int num);
}