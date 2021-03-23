package com.sca.common.dao;

import com.sca.common.model.CommonUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommonUserMapper {
	int deleteByPrimaryKey(String id);

	int insert(CommonUser record);

	int insertSelective(CommonUser record);

	CommonUser selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(CommonUser record);

	int updateByPrimaryKey(CommonUser record);
}