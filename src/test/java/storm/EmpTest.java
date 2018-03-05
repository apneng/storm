package storm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ggy.controller.EmpCtrl;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class EmpTest {
	@Autowired
	private EmpCtrl empCtrl;
	
	@Test
	public void testShowEmp(){
		String str = empCtrl.showEmps();
//		System.out.println(str);
		
		
	}

}
