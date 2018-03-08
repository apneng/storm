package storm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ggy.controller.EmpCtrl;
import com.ggy.pojo.Emp;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class TestEmp {
	@Autowired
	private EmpCtrl empCtrl;
	
//	@Test
//	public void testShowEmp(){
//		String str = empCtrl.showEmps();
//		System.out.println(str);
//	}
//	
//	@Test
//	public void testAddEmp(){
//		Emp emp = new Emp();
//		emp.setEage(14);
//		emp.setEgender(2);
//		emp.setEmpid(04);
//		emp.setDeptid(4);
//		emp.setEname("tommy");
//		emp.setEphone("12345678912");
//		int count = this.empCtrl.addEmp(emp);
//		System.out.println(count);
//	}
	@Test
	public void testGetEmpByEmpid(){
		int id = 3;
		System.out.println(this.empCtrl.getEmpByEmpid(id).getEname());
	}
}
