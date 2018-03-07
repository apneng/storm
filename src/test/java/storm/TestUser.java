package storm;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.SubjectThreadState;
import org.apache.shiro.util.ThreadState;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ggy.Model.BaseResultModel;
import com.ggy.Model.DataModel;
import com.ggy.controller.UserCtrl;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({"classpath:spring-mybatis.xml"})
@ContextConfiguration({"classpath:*.xml"})
public class TestUser {
	@Autowired
	private UserCtrl userCtrl;
	@Autowired
	private ThreadState _threadState;
	@Autowired
	protected Subject _mockSubject;


	
	/**
	 * 注册测试
	 * 密码转MD5加密
	 */
//	@Test
//	public void psw2md5(){
//		User user = new User();
//		user.setUsername("admin1");
//		user.setPassword("123456");
//		int n = this.userCtrl.signUp(user);
//		System.out.println(n);
//	}

//	测试shiro登陆
	@Before
	public void before() {
	_mockSubject = Mockito.mock(Subject.class);
	_threadState = new SubjectThreadState(_mockSubject);
	_threadState.bind();
	}
	@Test
	public void testShiroLogin() throws Exception{
		String userName = "admin";
		String password = "123456";
		boolean rememberMe = false ;
		BaseResultModel model = new DataModel();
		model = this.userCtrl.checkLogin(userName, password, rememberMe, null);
		System.out.println(model.getRtnMsg());
		
	}

}
