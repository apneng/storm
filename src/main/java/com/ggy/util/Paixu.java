package com.ggy.util;

import org.junit.Test;

/**用来测试几种排序法
 * @author apneng
 * 2018年3月12日 上午9:37:34
 */
public class Paixu {
	@Test
//	1直接插入排序
	/*在要排序的一组数中，假设前面(n-1)[n>=2] 个数已经是排
好顺序的，现在要把第n个数插到前面的有序数中，使得这n个数
也是排好顺序的。如此反复循环，直到全部排好顺序。*/
	public void zhiJiePaixu(){
		System.out.println("vvvvv直接插入排序测试vvvvv");
		int a[]={12,23,56,45,12,32,2,56,65,25,24,85,95};
		int temp = 0;
		for (int i = 0; i < a.length; i++) {
			int j = i-1;
			temp  = a[i];
			for (; j>=0 && temp < a[j]; j--) {
				a[j+1] = a[j];
			}
			a[j+1] = temp;
		}
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+"  ");
		}
	}
//	2希尔排序
/*	算法先将要排序的一组数按某个增量d（n/2,n为要排序数的个数）分成若干组，
	每组中记录的下标相差d.对每组中全部元素进行直接插入排序，
	然后再用一个较小的增量（d/2）对它进行分组，在每组中再进行直接插入排序。
	当增量减到1时，进行直接插入排序后，排序完成。*/
	@Test
	public void shell(){
		System.out.println("vvvvv最小增量排序vvvvv");
		int a[] = {54,21,5,2,15,6,5,12,156,32,32};
		double d1 = a.length;
		int temp = 0;
		while(true){
			d1 = Math.ceil(d1/2);
			int d = (int) d1;
			for (int x = 0; x < d; x++) {
				for (int i = x+d; i < a.length; i+=d) {
					int j =i-d;
					temp = a[i];
					for (; j>=0 && temp <a[j]; j-=d) {
						a[j+d] =a[j];
					}
					a[j+d] =temp;
				}
			}
			if(d ==1 ){
				break;
			}
			
		}
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
	}
//3	简单选择排序
/*	在要排序的一组数中，选出最小的一个数与第一个位置的数交换；

	然后在剩下的数当中再找最小的与第二个位置的数交换，如此循环到倒数第二个数和最后一个数比较为止。*/
	@Test
	public void jiandanPx(){
		System.out.println("简单排序vvv");
		int a[] = {54,65,8,5,2,8,987,95,52,46};
		int position=0;  
	       for(int i=0;i<a.length;i++){       
	           int j=i+1;  
	           position=i;  
	           int temp=a[i];  
	           for(;j<a.length;j++){  
	              if(a[j]<temp){  
	                 temp=a[j];  
	                 position=j;  
	              }  
	           }  
	           a[position]=a[i];  
	           a[i]=temp;  
	       }  
	   
	       for(int i=0;i<a.length;i++)  
	           System.out.print(a[i]+" ");  
	    }  

//	冒泡法排序
	@Test
	public void maopao(){
		System.out.println("冒泡排序vvv");
		int a[] = {12,54,8,7,4,20,123,45,52,2};
		int temp = 0 ;
		for (int i = 0; i < a.length-1; i++) {
			for (int j = 0; j < a.length-1; j++) {
				if(a[j] > a[j+1]){
					temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
	}
	
	@Test
	public void maopao1(){
		System.out.println("冒泡排序1vvv");
		int a[] = {12,54,8,7,4,20,123,45,52,2};
		int temp = 0 ;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < i; j++) {
				if(a[j] > a[i]){
					temp = a[j];
					a[j] = a[i];
					a[i] = temp;
				}
			}
		}
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
	}
	
	
}
