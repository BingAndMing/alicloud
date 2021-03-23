package com.sca.order.dao;

import com.sca.order.model.OrderRecord;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderRecordMapper {
	int deleteByPrimaryKey(String id);

	int insert(OrderRecord record);

	int insertSelective(OrderRecord record);

	OrderRecord selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(OrderRecord record);

	int updateByPrimaryKey(OrderRecord record);
}