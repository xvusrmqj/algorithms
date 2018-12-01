package 互联网公司.网易;

import java.util.Arrays;

/**
 * 
 * 有一个整数数组，请你根据快速排序的思路，找出数组中第K大的数。
 * 给定一个整数数组a,同时给定它的大小n和要找的K(K在1到n之间)，请返回第K大的数，保证答案存在。
 * 测试样例：
 * [1,3,5,2,2],5,3
 * 返回：2
 * 
 * @author lv
 */
public class 寻找第K大 {
	public static int findKth(int[] a, int n, int K) {
    	Arrays.sort(a);
    	int count = 0;
    	for (int i =  a.length-1; i >= 0; i--) {
			count ++;
			if(count == K) return a[i];
		}
    	return -1;
    }
}
