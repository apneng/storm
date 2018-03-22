package com.ggy.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

}
