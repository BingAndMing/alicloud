package com.sca.order.clients;

import com.sca.order.clients.fallback.CommonClientsFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "sca-common",fallback = CommonClientsFallback.class)
public interface CommonClients {
	
	@RequestMapping(value = "/CommonUser/getUserInfoByUserId.do")
	public String getUserInfoByUserId(@RequestParam("userId") String userId);
}
