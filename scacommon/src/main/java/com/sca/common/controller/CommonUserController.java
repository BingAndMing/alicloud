package com.sca.common.controller;

import com.alibaba.fastjson.JSON;
import com.sca.common.model.CommonUser;
import com.sca.common.service.CommonUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/CommonUser")
public class CommonUserController {
	@Resource
	private CommonUserService commonUserService;
	
	@RequestMapping(value = "/getUserInfoByUserId.do")
	public String getUserInfoByUserId(@RequestParam("userId") String userId){
		CommonUser user = commonUserService.getCommonUserByUserId(userId);
		if(user == null){
			return null;
		}
		return JSON.toJSONString(user);
	}
}
