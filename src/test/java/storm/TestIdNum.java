package storm;

import org.junit.Test;

import com.ggy.util.IdNum;

public class TestIdNum {
	@Test
	public void testid() {
		String idnum = "15230019850804191X";
		boolean a = IdNum.isValidatedAllIdcard(idnum);
		System.out.println(a);
	}

}
