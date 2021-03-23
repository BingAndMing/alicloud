package com.sca.common.service.impl;

import com.sca.common.dao.CommonUserMapper;
import com.sca.common.model.CommonUser;
import com.sca.common.service.CommonUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class CommonUserServiceImpl implements CommonUserService {
	@Resource
	private CommonUserMapper commonUserMapper;
	
	@Override
	@Transactional
	public CommonUser getCommonUserByUserId (String userId) {
		return commonUserMapper.selectByPrimaryKey(userId);
	}
}
