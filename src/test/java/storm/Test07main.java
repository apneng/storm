package storm;

/**多线程，测试for循环写法的速度
 * @author apneng
 * 2018年4月8日 下午5:13:34
 */
public class Test07main {
	public static void main(String[] args) {
		Test071 t1 = new Test071();
		Test072 t2 = new Test072();
		Test074 t4 = new Test074();
		t1.start();
		t2.start();
		try {
			long t4Time = t4.call();
			System.out.println(t4.call()*2);
			System.out.println("074返回的时间="+t4Time);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
