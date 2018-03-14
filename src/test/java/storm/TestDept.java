package storm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ggy.controller.DeptCtrl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class TestDept {
	@Autowired
	private DeptCtrl deptCtrl;
	@Test
	public void showDept(){
		System.out.println(this.deptCtrl.showDept());
	}
	@Test
	public void getDeptid(){
		System.out.println(this.deptCtrl.getDeptIdByDname("人事部"));
		System.out.println(this.deptCtrl.getDeptIdByDname("开发部"));
		System.out.println(this.deptCtrl.getDeptIdByDname("研发部"));
		
	}
}
