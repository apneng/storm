package storm;

//测试垃圾回收机制finalize
public class Test05 {
	static boolean gicrun = false;
	static boolean f = false;
	static int created = 0;
	static int finalized = 0;
	int i;

	Test05() {
		i = ++created;
		if (created == 47) {
			System.out.println("Created47");
		}
	}

	protected void finalize() {
		if (!gicrun) {
			gicrun = true;
			System.out.println("beginning to finalize after " + created + " Test05 have been created");
		}
		if (i == 47) {
			System.out.println("Finalizing Test05 #47 , Setting flag to stop Test05 creation");
			f = true;
		}
		finalized++;
		if (finalized >= created) {
			System.out.println("All" + finalized + "finalized");
		}
	}
}

