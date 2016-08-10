package leetcode.easy;

/**
303. Range Sum Query - Immutable
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
Note:
You may assume that the array does not change.
There are many calls to sumRange function.
*/
public class NO303 {
	int[] sums;

	public static void main(String[] args) {
		int[] nums = { -2, 0, 3, -5, 2, -1 };
		NO303 no303 = new NO303(nums);
		int sumRange1 = no303.sumRange(0, 2);
		int sumRange2 = no303.sumRange(2, 5);
		int sumRange3 = no303.sumRange(0, 5);
		System.out.println(sumRange1);
		System.out.println(sumRange2);
		System.out.println(sumRange3);

	}

	public NO303(int[] nums) {
		sums = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			if (i == 0)
				sums[i] = nums[i];
			else {
				sums[i] = sums[i - 1] + nums[i];
			}
		}
	}

	public int sumRange(int i, int j) {
		if (i == 0)
			return sums[j];
		return sums[j] - sums[i - 1];
	}
	// Your NumArray object will be instantiated and called as such:
	// NumArray numArray = new NumArray(nums);
	// numArray.sumRange(0, 1);
	// numArray.sumRange(1, 2);
}
