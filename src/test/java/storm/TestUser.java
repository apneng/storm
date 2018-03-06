package storm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ggy.controller.UserCtrl;
import com.ggy.pojo.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class TestUser {
	@Autowired
	private UserCtrl userCtrl;
	
	@Test
	public void psw2md5(){
		User user = new User();
		user.setUsername("澳门");
		user.setPassword("123789");
		int n = this.userCtrl.signUp(user);
		System.out.println(n);
	}

}
