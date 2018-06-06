package storm;
//数组的研究
public class Test06 {
	public static final String adc = "";
	public static void main(String[] args) {
		int[] a = {1,2,5,3,4,5};
		System.out.println("数组a对象:"+a);
		int[] b = a;
		System.out.println("数组b对象:"+b);
		int[] c = {1,2,5,3,4,5};
		System.out.println("数组c对象:"+c);
		System.out.println("a==b ? "+(a==b));
		System.out.println("a==c ? "+(a==c));
		a[0] = 2; //仅仅改变 数组a中元素的值，通过下面的输出发现数组b也跟着
		System.out.println("修改后数组a对象:"+a);
		System.out.println("数组b对象:"+b);
		System.out.print("数组a: ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
		System.out.print("数组b: ");
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i]+" ");
		}
		System.out.println();
//解释：如果A,B是两个同类型的数组,复制就相当于将一个数组变量的引用传递给另一个数组;如果一个数组发生改变,那么引用同一数组的变量也要发生改变.

//		拓展String研究
		String s = "helloworld";
		String s1 = s;
		String s2 = new String("helloworld");
		System.out.println("s==s1?"+(s==s1));
		System.out.println("s equals s1?"+(s.equals(s1)));
		System.out.println("s==s2 ?"+(s==s2));
		System.out.println("s equals s2 ?"+(s.equals(s2)));
		s = "change";
		System.out.println("s==s1?"+(s==s1));
		System.out.println("s equals s1?"+(s.equals(s1)));
	}

	public static void te(){
		System.out.println("test06method");
	}
}
