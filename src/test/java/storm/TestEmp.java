package storm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ggy.Model.BaseResultModel;
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
	@Test
	public void testAddEmp(){
		Emp emp = new Emp();
		emp.setEage(14);
		emp.setEgender(1);
		emp.setEmpid(2);
		emp.setDeptid(4);
		emp.setEname("tommy");
		emp.setEphone("12345678912");
		
		BaseResultModel count = this.empCtrl.updateEmp(emp);
		System.out.println(count.getRtnMsg());
	}
//	@Test
//	public void testGetEmpByEmpid(){
//		int id = 3;
//		System.out.println(this.empCtrl.getEmpByEmpid(id).getEname());
//	}
}
