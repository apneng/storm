package com.ggy.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.ggy.Model.BaseResultModel;
import com.ggy.pojo.Cal;
import com.ggy.service.CalService;
import com.ggy.util.SysCode;
import com.ggy.util.Time;

@Controller
@RequestMapping("calCtrl")
public class CalCtrl {
	@Autowired
	private CalService calService;
	@ResponseBody
	@RequestMapping("/insertOrUpdate")
	public BaseResultModel insertOrUpdate(Cal cal,HttpServletRequest request){
		System.out.println(cal.toString());
		BaseResultModel model = new BaseResultModel();
		Time ti = new Time();
		//判断日程是否存在
		boolean isExist = this.calService.isExist(cal.getCalid());
		if(isExist){//存在则修改
			System.out.println("执行修改");
//			cal.setEntWho(userid);
			Date date = new Date();
			cal.setEntWhen(date);
			int count = this.calService.update(cal);
			if(count > 0){
				model.setRtnCode(SysCode.RTN_CODE_SUCCESS);
				model.setRtnMsg("修改日程成功");
			}else{
				model.setRtnCode(SysCode.RTN_CODE_FAIL);
				model.setRtnMsg("修改日程出错");
			}
			
		}else{//不存在则新增
			System.out.println("执行新增");
			cal.setCalid(UUID.randomUUID().toString().replace("-", ""));
//			cal.setEntWho(userid);
			Date date = new Date();
			cal.setEntWhen(date);
			int count =this.calService.insert(cal);
			if(count > 0){
				model.setRtnCode(SysCode.RTN_CODE_SUCCESS);
				model.setRtnMsg("添加日程成功");
			}else{
				model.setRtnCode(SysCode.RTN_CODE_FAIL);
				model.setRtnMsg("添加日程出错");
			}
			
		}
		return model;
	}
	
	@ResponseBody
	@RequestMapping("/getCals")
	public String getCals(){
		List<Date> list = this.calService.getCals();
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
		String json = JSON.toJSONString(list);
//		System.out.println(json);
		return json;
	}
	@ResponseBody
	@RequestMapping("/getCalByDate")
	public String getCalByDate(String startDate) {
		
		List<Map<String,String>> list = this.calService.getCalByDate(startDate);
		String json = JSON.toJSONString(list);
		System.out.println(json);
		return json;
	}
}
