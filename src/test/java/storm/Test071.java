package storm;

/**多线程，测试for循环写法的速度
 * @author apneng
 * 2018年4月8日 下午5:13:28
 */
public class Test071 implements Runnable {
	private Thread t;
	
	public Test071() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("线程071");
		long t1 = System.currentTimeMillis();
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(3000);
				System.out.println("071--"+i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("071耗时--"+(System.currentTimeMillis()-t1));
	}

	public void start() {
		// TODO Auto-generated method stub
		if (t == null) {
			t = new Thread(this);
			t.start();

		}
	}
}
