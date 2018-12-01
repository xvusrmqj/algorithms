package leetcode.hard;

import org.junit.Test;

import tools.ListNode;

/*
 * 287. Find the Duplicate Number
 * 
 * Given an array nums containing n + 1 integers where each integer is between 1
 * and n (inclusive), prove that at least one duplicate number must exist.
 * Assume that there is only one duplicate number, find the duplicate one.
 * 
 * Note:
 * 1. You must not modify the array (assume the array is read only).
 * 2. You must use only constant, O(1) extra space.
 * 3. Your runtime complexity should be less than O(n2).
 * 4. There is only one duplicate number in the array, but it could be repeated more than once.
 * 
 * https://www.hrwhisper.me/leetcode-find-the-duplicate-number/
 * 思路：
 * 1. 因为时间复杂度要求要小于O(n2), 所以不能用朴素的判别。
 * 2. 空间复杂度O(1)所以不能hash，
 * 3. 不能修改所以不能排序,
 * 4. 可能不止重复一次所以不能n项和
 */
public class NO287 {
	@Test
	public void test() {
	}

    public int findDuplicate(int[] nums) {
        return 0;
    }

}
