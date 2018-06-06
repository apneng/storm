package storm;

/**
 * 创建一个工厂，生成基于给定信息的实体类的对象
 * 
 * @author apneng
 * 2018年4月9日 上午10:11:24
 */
public class Test09Factory {
	
	public Test09 get09(String test09Type){
		if(test09Type == null){
			return null;
		}
		
		if(test09Type.equalsIgnoreCase("test091")){
			return new Test091();
		}
		if(test09Type.equalsIgnoreCase("test092")){
			return new Test092();
		}
		if(test09Type.equalsIgnoreCase("test093")){
			return new Test093();
		}
		return null;
	}

}
