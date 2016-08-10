package leetcode.easy;

/**
376. Wiggle Subsequence
A sequence of numbers is called a wiggle sequence if the differences between 
successive numbers strictly alternate between positive and negative. The first
difference (if one exists) may be either positive or negative. A sequence with 
fewer than two elements is trivially a wiggle sequence.

For example, [1,7,4,9,2,5] is a wiggle sequence because the differences 
(6,-3,5,-7,3) are alternately positive and negative. In contrast, [1,4,7,2,5]
 and [1,7,4,5,5] are not wiggle sequences, the first because its first two 
 differences are positive and the second because its last difference is zero.

Given a sequence of integers, return the length of the longest subsequence that
is a wiggle sequence. A subsequence is obtained by deleting some number of
elements (eventually, also zero) from the original sequence, leaving the remaining 
elements in their original order.

Examples:
Input: [1,7,4,9,2,5]
Output: 6
The entire sequence is a wiggle sequence.

Input: [1,17,5,10,13,15,10,5,16,8]
Output: 7
There are several subsequences that achieve this length. One is [1,17,10,13,10,16,8].

Input: [1,2,3,4,5,6,7,8,9]
Output: 2
*/
public class NO367 {
	/**
	 * 本题的错误是方法的错误. 而在错误的方法里一直死扣. 
	 * 测试用例没有考虑重复的问题.
	 * 当然也没有考虑重复元素的位置. 在开头,在中间.
	 * @param args
	 */
	public static void main(String[] args) {
				int[] arr = { 1, 17, 5, 10, 13, 15, 10, 5, 16, 8 };//7
		//		int[] arr = {};
		//		int[] arr = {1};
		//		int[] arr = {1,17};
		//		int[] arr = {0,0};
		//		int[] arr = {3,3,3,2,5};//3
		//		int[] arr = null;
//		int[] arr = { 2, 3, 3, 1 };//3
		int wiggleMaxLength = wiggleMaxLength(arr);
		System.out.println(wiggleMaxLength);
	}

	/**
	 * @param nums
	 * @return
	 */
	public static int wiggleMaxLength(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		//dp[i]代表数组前i个元素的最长序列
		int[] dp = new int[nums.length];
		//sign[i]代表数组前i个元素的最长序列的最后元素元素的差值符号.
		int[] sign = new int[nums.length];
		//数组为单个元素的情况{1}
		if (nums.length == 1)
			return nums.length;
		dp[0] = 1;
		sign[0] = 0;
		int begin = 1;
		//数组为连续多个重复的情况{1,1,1,1,1,2,1,3},为了初始化begin, sign[], dp[]
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] - nums[i - 1] == 0) {
				dp[i] = 1;
				sign[i] = 0;
			} else {
				begin = i + 1;
				dp[i] = 2;
				sign[i] = nums[i] - nums[i - 1] > 0 ? 1 : -1;
				break;
			}

		}
		//从begin开始到最后.
		for (int i = begin; i < nums.length; i++) {
			if (nums[i] - nums[i - 1] > 0) {
				if (sign[i - 1] < 0) {
					dp[i] = dp[i - 1] + 1;
					sign[i] = -sign[i - 1];
				} else {
					dp[i] = dp[i - 1];
					sign[i] = sign[i - 1];
				}
			} else if (nums[i] - nums[i - 1] < 0) {
				if (sign[i - 1] > 0) {
					dp[i] = dp[i - 1] + 1;
					sign[i] = -sign[i - 1];
				} else {
					dp[i] = dp[i - 1];
					sign[i] = sign[i - 1];
				}
			} else {
				dp[i] = dp[i - 1];
				sign[i] = sign[i] = sign[i - 1];
			}
		}
		return dp[nums.length - 1];
	}

}
