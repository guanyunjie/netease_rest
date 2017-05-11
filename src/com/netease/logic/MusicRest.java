package com.netease.logic;

import com.alibaba.fastjson.JSONObject;
import com.netease.bean.EntityBean;
import com.netease.bean.Student;

public class MusicRest {
	
	public EntityBean user_ingo(EntityBean param){
		EntityBean result = new EntityBean();
		Student student = new Student();
		student.setName("官云杰");
		student.setAge("56");
		
		String st = JSONObject.toJSONString(student);
		
		JSONObject json = JSONObject.parseObject(st);
		result.setResult(json);
		
		return result;
	}
	
	
}
