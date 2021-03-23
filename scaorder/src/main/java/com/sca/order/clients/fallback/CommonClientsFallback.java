package com.sca.order.clients.fallback;

import com.alibaba.fastjson.JSONObject;
import com.sca.order.clients.CommonClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @ClassName
 * @Author dell
 * @Date 2021/3/17 15:58
 * @Version 1.0
 * @Description
 **/
@Component(value = "commonClientsFallback")
public class CommonClientsFallback implements CommonClients {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Override
	public String getUserInfoByUserId(String userId) {
		logger.error("查用户异常了");
		return "error";
	}
}
