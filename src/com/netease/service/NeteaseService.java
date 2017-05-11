package com.netease.service;

import com.netease.bean.EntityBean;
import com.netease.logic.MusicRest;

/**
 * <b>&nbsp;&nbsp;&nbsp;&nbsp;请求分发</b>
 */
public class NeteaseService {
	
	public EntityBean user_login(EntityBean param){
		MusicRest logic = new MusicRest();
		
		return logic.user_ingo(param);
	}
}
