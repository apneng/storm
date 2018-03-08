package com.ggy.controller;

import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ggy.Model.BaseResultModel;
import com.ggy.Model.DataModel;
import com.ggy.pojo.User;
import com.ggy.service.EmpService;
import com.ggy.service.UserService;
import com.ggy.util.MD5;
import com.ggy.util.SysCode;

@Controller
@RequestMapping("userCtrl")
public class UserCtrl {
	@Autowired
	private UserService userServices;
	
//	登陆
	@ResponseBody
	@RequestMapping("checkLogin")
	public BaseResultModel checkLogin(String userName,String password,boolean rememberMe, HttpServletRequest request)
		throws Exception{
		DataModel model = new DataModel();
		UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
		token.setRememberMe(rememberMe);
		Subject subject = SecurityUtils.getSubject();

		try {
			subject.login(token);
			if (subject.isAuthenticated()) {
				model.setRtnCode(SysCode.RTN_CODE_SUCCESS);
				model.setRtnMsg("登录成功!");
				User user = (User) subject.getSession().getAttribute("loginUser");
//				String agent = request.getHeader("User-Agent");
//				String clientIp = request.getRemoteAddr();
				model.setData(user);
			} else {
				model.setRtnCode(SysCode.RTN_CODE_FAIL);
				model.setRtnMsg("登录失败!");
			}
		} catch (UnknownAccountException arg10) {
			arg10.printStackTrace();
			model.setRtnCode(SysCode.RTN_CODE_FAIL);
			model.setRtnMsg("用户名不存在!");
		} catch (IncorrectCredentialsException arg11) {
			arg11.printStackTrace();
			model.setRtnCode(SysCode.RTN_CODE_FAIL);
			model.setRtnMsg("密码错误!");
		} catch (LockedAccountException arg12) {
			arg12.printStackTrace();
			model.setRtnCode(SysCode.RTN_CODE_FAIL);
			model.setRtnMsg("账户已锁定!");
		} catch (Exception arg13) {
			arg13.printStackTrace();
			model.setRtnCode(SysCode.RTN_CODE_FAIL);
			model.setRtnMsg("登录失败!");
		}

		return model;
	}
//	注册
	@ResponseBody
	@RequestMapping("signUp")
	public int signUp(User user){
		MD5 md5 = new MD5();
		Date date =  new Date();
		user.setRegtime(date);
		user.setId(UUID.randomUUID().toString().replace("-", ""));
		user.setPassword(md5.getMD5ofStr(user.getPassword()));
		return this.userServices.signUp(user);
		
	}

//	测试
	@RequestMapping("ddd")
	public String aa(@Param("yonghu") String yonghu){
		System.out.println(yonghu);
		return "404";
		
	}

}
