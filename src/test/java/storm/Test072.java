package storm;


/**多线程，测试for循环写法的速度
 * @author apneng
 * 2018年4月8日 下午5:13:51
 */
public class Test072 implements Runnable {
	private Thread t;

	public Test072() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("线程072");
		long t1 = System.currentTimeMillis();
		for (int i = 0; i < 5; i++) {
			if(i == 3){
				Thread.interrupted();
/*调用线程的interrupt() 方法不会中断一个正在运行的线程，这个机制只是设置了一个线程中断标志位，
如果在程序中你不检测线程中断标志位，那么即使设置了中断标志位为true，线程也一样照常运行。*/
				
				if(Thread.currentThread().isInterrupted()){
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			System.out.println("072---------------------" + i);
		}
		System.out.println("072耗时--" + (System.currentTimeMillis() - t1));

	}

	public void start() {
		// TODO Auto-generated method stub
		if (t == null) {
			t = new Thread(this);
			t.start();

		}
	}

}
