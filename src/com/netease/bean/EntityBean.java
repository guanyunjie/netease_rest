package com.netease.bean;

import java.io.Serializable;

import com.alibaba.fastjson.JSONObject;

public class EntityBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JSONObject result;

	public JSONObject getResult() {
		return result;
	}

	public void setResult(JSONObject result) {
		this.result = result;
	}
	
	public Object par(String key){
		return result.get(key);
	}
	
}
