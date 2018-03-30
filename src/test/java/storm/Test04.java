package storm;

import java.util.Random;

public class Test04 {
	static void f(Letter y){
		y.c = 'z';
	}
	public static void main(String[] args) {
		Letter x = new Letter();
		x.c ='d';
		System.out.println("1:x.c>"+x.c);
		f(x);
		System.out.println("2:x.c>"+x.c);
		int i = 1;
		System.out.println(i);
		System.out.println(i++);
		System.out.println(++i);
		int n1 = 45;
		int  n2 = 45;
		System.out.println(n1==n2);
		Integer m1 = new Integer(45);
		Integer m2 = new Integer(45);
		System.out.println(m1==m2);
		System.out.println(m1.equals(m2));
		Random rand = new Random();
		int a = rand.nextInt(100);
		int b = rand.nextInt(100);
		System.out.println("a = "+a);
		System.out.println("b = "+b);
		System.out.println("a > b is "+(a>b));
		System.out.println("a ^ b ="+(a^b));//位异或运算，不进位，相同为0，不同为1
		int c = 256;
//		c>>>=10; //将移位后的结果赋值给左边c
//		System.out.println(c);
		System.out.println(c>>>4);
		
//		异或的用法研究 GO
	/*1-1000放在含有1001个元素的数组中，只有唯一的一个元素值重复，其它均只出现
		一次。每个数组元素只能访问一次，设计一个算法，将它找出来；不用辅助存储空
		间，能否设计一个算法实现？*/
//		方法1：1+2+3+...+1001 - （1+2+3+...+1000）即可算出重复的数，但数组过大情况下可能溢出，不实用
//		采用异或的方法
		int[] d = new int[1001];
		for (int j = 0; j < d.length-1; j++) {
			d[j] = j;
		}
		d[1000] = 12;
		int e = 0;
		for (int j = 0; j < d.length; j++) {
			e ^= d[j];
		}
		System.out.println(e);//输出重复值
//		异或研究暂时到此 END
		
		for (int j = 0; j < 50; j++) {
			if(j == 40){
				break;
			}
			if(j%10 == 0){
				System.out.println();
				continue;
			}
			System.out.print(j+" ");
		}
		System.out.println();
		
		Test01.pri("");
		Test02.pri("");
		int fina = 10;
		System.out.println(fina);
	}
}
