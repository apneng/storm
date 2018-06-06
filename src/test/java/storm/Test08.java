package storm;

/**单例模式
 * @author apneng
 * 2018年4月9日 上午9:45:03
 */
public class Test08 {
	private static Test08 instance = new Test08();//在本类中实例化本类
	
	private Test08(){};//设置为private，保证该类不能被new（实例化）
	
	public static Test08 getInstance(){//获取唯一可用对象
		return instance;
	}
	
	public void showMessage(){
		System.out.println("hello world");
		
	}
}
