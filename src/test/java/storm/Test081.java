package storm;

/**单例模式
 * @author apneng
 * 2018年4月9日 上午10:03:22
 */
public class Test081 {
	public static void main(String[] args) {
		Test08 t8 = Test08.getInstance();
		t8.showMessage();
	}

}
