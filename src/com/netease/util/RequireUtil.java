package com.netease.util;

import java.lang.reflect.Method;

import com.alibaba.fastjson.JSONObject;
import com.netease.bean.EntityBean;
import com.netease.service.NeteaseService;

public class RequireUtil {
	
	
	
	public static String invoke(String json,NeteaseService netService){
		JSONObject jsonObject = JSONObject.parseObject(json);
		String service = jsonObject.getString("service");
		JSONObject data = jsonObject.getJSONObject("data");
		
		EntityBean param = new EntityBean();
		param.setResult(data);
		
		Object result = "";
		try {
			Method method = netService.getClass().getDeclaredMethod(service, EntityBean.class);
			result = method.invoke(netService, param);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return JSONObject.toJSONString(result);
	}
}
