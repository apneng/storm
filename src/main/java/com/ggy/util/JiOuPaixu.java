package com.ggy.util;

/**奇偶排序
 * 1：先将待排序数组的所有奇数位与自己身后相邻的偶数位相比较，如果前者大于后者，则进行交换，直到这一趟结束。

2：然后将偶数位与自己身后相邻的奇数位相比较，如果前者大于后者，则进行交换，直到这一趟结束。

3：重复1，2的步骤，直到发现无“奇偶”，“偶奇” 交换的时候，就认为排序完毕，此时退出循环
 * @author apneng
 * 2018年3月9日 下午3:43:48
 */
public class JiOuPaixu {
	public static void main(String[] args) {
		int array[] = {5,21,5,46,48,312,52,54,96,4};
		System.out.print("排序前>>>>>");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" ");
		}
        
		int arrayLength = array.length;
        boolean oddSorted = false;
        boolean evenSorted = false;

        while(!oddSorted || !evenSorted) {
            oddSorted = true;
            evenSorted = true;

            for (int i = 0; i < arrayLength - 1; i += 2) {
                if (array[i] > array[i + 1]) {
                	int a = array[i];
                	array[i] =array[i + 1];
                	array[i + 1]=a;
                    oddSorted = false;
                }
            }

            for (int i = 1; i < arrayLength - 1; i += 2) {
                if (array[i] > array[i + 1]) {
                	int a = array[i];
                	array[i] =array[i + 1];
                	array[i + 1]=a;
                    evenSorted = false;
                }
            }
        }
        System.out.println();
        System.out.print("排序后>>>>>");
        for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" ");
		}
	}

}
