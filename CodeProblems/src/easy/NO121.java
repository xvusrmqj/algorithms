package easy;

import static org.junit.Assert.*;

import org.junit.Test;


/**
 * 121. Best Time to Buy and Sell Stock 
 * 
 * Say you have an array for which the i'th element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one
 * share of the stock), design an algorithm to find the maximum profit.
 */
public class NO121 {
	@Test
	public void test(){
		// in leetcode . input:[1] expected :0
		int[] prices = {1};
		int result = maxProfit_wrong(prices);
		assertEquals(0,result);
	}
	//错误的解法
	public int maxProfit_wrong(int[] prices) {
		// boundary condition
		if (prices == null || prices.length == 0)
			return 0;
		// 
		int maxPriceIndex = 0;
		int minPriceIndex = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[maxPriceIndex]) {
				maxPriceIndex = i;
			}
			if (prices[i] < prices[minPriceIndex]) {
				minPriceIndex = i;
			}
		}
		return maxPriceIndex == minPriceIndex?0:prices[maxPriceIndex]-prices[minPriceIndex];
	}
	// 正确的解决:穷举法 bad
	public int maxProfit1(int[] prices) {
		// boundary condition
		if (prices == null || prices.length == 0)
			return 0;
		//方法1: 先用限制. 找从0买入的最大,从1买入的最大...从N买入的最大,再比较这些最大
		//方法2: 后用限制. 找最大值和最小值,看是不是满足限制,不满足将这两个点去掉,再找最大值最小值...(此方法不行,会丢解)
		int maxPro = 0;
		for(int i = 0;i<prices.length;i++){
			for(int j=i+1;j<prices.length;j++){
				//...
			}
		}
		return 0;
		
	}
	// 正确的解决:减治法
	public int maxProfit2(int[] prices) {
		// boundary condition: this is right.
		if (prices == null || prices.length <= 1)
			return 0;
		// 新加入一个元素a后,由于新加入的元素a只可能是卖出.那么如果利润改变必然是a - 以前的最小值min.
		// 判断a-min>maxProfit.
		int maxPro = 0;
		int currentMinPrice = prices[0];
		for(int i =0;i<prices.length;i++){
			maxPro = Math.max(prices[i] - currentMinPrice,maxPro);
			currentMinPrice = Math.min(currentMinPrice,prices[i]);
		}
		return maxPro;
	}
}
/**
 * 题目分析:
 * 就是低进高买,而且就让你交易一次(至多).
 * 
 * 错误分析:
 * 1. 边界条件:数组不能为空,长度不能为0----oh! not 0 but 0 and 1.
 * 2. 买卖的具体情景:只有先买才能后卖(有一个隐藏的时间顺序限制). 所以maxProfit1()方法不对.
 */
