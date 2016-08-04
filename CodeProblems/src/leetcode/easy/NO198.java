package leetcode.easy;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 198. House Robber
 * 
 * You are a professional robber planning to rob houses along a street. Each house 
 * has a certain amount of money stashed, the only constraint stopping you from robbing 
 * each of them is that adjacent houses have security system connected and it will 
 * automatically contact the police if two adjacent houses were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of each house, 
 * determine the maximum amount of money you can rob tonight without alerting the police.
 * 
 * @author lv
 *
 */
public class NO198 {
	@Test
	public void test(){
		//input:[2,1,1,2] expected:4
		//input:[2,3,2] expected:4
		//input:[1,1] expected:2
		int rob = rob(new int[]{1,1});
		assertEquals(1, rob);
	}
	//wrong solution. 奇数位加一遍偶数位加一遍比最大，这样不对。
	public int rob_wrong(int[] nums) {
		int oddMax = 0;
		int evenMax = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i % 2 == 0)
				evenMax += nums[i];
			else
				oddMax += nums[i];
		}
		return Math.max(oddMax, evenMax);
	}
	//wrong solution.减治法。
	public int rob_wrong2(int[] nums){
		int max= 0;
		int currentIndex = -100;
		for(int i =0;i<nums.length;i++){
			if(currentIndex!=i-1){
				max+=nums[i];
				currentIndex = i;
			}else{
				if(nums[currentIndex]<nums[i]){
					max-=nums[currentIndex];
					max+=nums[i];
					currentIndex = i;
				}
			}
		}
		return max;
	}
	public int rob(int[] nums){
		return 0;
	}
}










