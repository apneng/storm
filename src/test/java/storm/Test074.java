package storm;

import java.util.concurrent.Callable;

/**多线程返回结果
 * thread 和 runable中的run方法无法返回结果，这里继承callable来实现
 * @author apneng
 * 2018年4月8日 下午5:17:41
 */
public class Test074 implements Callable<Long>{

	@Override
	public Long call() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("线程074");
		long t1 = System.currentTimeMillis();
		for (int i = 0, t =5; i < t; i++) {
		
			Thread.sleep(i*1000);
			System.out.println("074---"+i);
		}
		long time = System.currentTimeMillis()-t1;
		System.out.println("074耗时--"+time);
		return time;
	}

}
