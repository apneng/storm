package com.ggy.util.filter;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.ggy.pojo.User;
import com.ggy.service.UserService;
import com.ggy.util.MD5;

public class AuthRealm extends AuthorizingRealm{
	@Autowired
	private UserService userService;

public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	//	用于授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}
//	用于认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
//		System.out.println("authRealm>>>>>>开始认证>>>>>>>>>");
		String userName = (String) token.getPrincipal();
		String password = new String((char[]) token.getCredentials());
		Subject subject = SecurityUtils.getSubject();
		User user = this.userService.findUserByName(userName);
		if (user == null) {
			throw new LockedAccountException("不存在该用户");
		}else if (user.getStatus() != 0) {
			throw new LockedAccountException();
		}else{
			MD5 md5 = new MD5();
			if (!md5.getMD5ofStr(password).equals(user.getPassword())) {
				throw new IncorrectCredentialsException("密码错误");
			} else {
				subject.getSession().setAttribute("loginUser", user);
				SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getId(), password,
						this.getName());
				return authenticationInfo;
			}
		}
		
	}
	public void getAuthorization(PrincipalCollection principals) {
		this.doGetAuthorizationInfo(principals);
	}

	public void clearAuthz() {
		this.clearCachedAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());
	}
}
