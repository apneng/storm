package storm;
//调用test05测试finalize垃圾回收机制
public class Test051 {
	public static void main(String[] args) {
		if(args.length == 0){
			System.out.println("Usage:\n java Test051 before \n or:\n java Test051 after");
			return ;
		}
		while (!Test05.f){
			new Test05();
			new String("To take up space");
		}
		System.out.println("After all Test05 have been created:\n total created="+Test05.created+",total finalized = "+Test05.finalized);
		if(args[0].equals("before")){
			System.out.println("gc():");
			System.gc();
			System.out.println("runFinalize():");
			System.runFinalization();
		}
		System.out.println("bye");
		if(args[0].equals("after")){
			System.runFinalizersOnExit(true);
		}
	}

}
