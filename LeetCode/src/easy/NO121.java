package easy;

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
		int[] prices = {1};
		int result = maxProfit(prices);
		
	}
	public int maxProfit(int[] prices) {
		// boundary condition
		if (prices == null || prices.length == 0)
			return 0;
		// 
		int maxPrice = prices[0];
		int minPrice = prices[0];
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > maxPrice) {
				maxPrice = prices[i];
			}
			if (prices[i] < minPrice) {
				minPrice = prices[i];
			}
		}
		return maxPrice = minPrice;
	}
}
