package 互联网公司.美团;

/**
 题目描述
有一个长为n的数组A，求满足0≤a≤b<n的A[b]-A[a]的最大值。
给定数组A及它的大小n，请返回最大差值。

测试样例：
[10,5],2
返回：0

@author lv
 */
public class 最大差值 {

	public static void main(String[] args) {

	}

	public static int getDis(int[] A, int n) {
        // write code here
        if(A==null||A.length==0) return 0;
		int max = Integer.MIN_VALUE;
        for(int b = 0;b<n;b++){
			for(int a = 0;a<b;a++){
				int val = A[b]-A[a];
				if(max<val) max = val;
        	}	
        }
        return max;
    }
}
