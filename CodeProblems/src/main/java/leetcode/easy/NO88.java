package leetcode.easy;

import org.junit.Test;

import tools.ListNode;

/**
88. Merge Sorted Array
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold 
additional elements from nums2. The number of elements initialized in nums1 and nums2 are m 
and n respectively.
 * 
 */
public class NO88 {

	@Test
	public void test() {
		merge(new int[] { 1, 0 }, 1, new int[] { 2 }, 1);
	}

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		for (int i = m + n - 1, j = m - 1, k = n - 1; i >= 0; i--) {
			if (j >= 0 && k >= 0) {
				if (nums1[j] > nums2[k]) {
					nums1[i] = nums1[j];
					j--;
				} else {
					nums1[i] = nums2[k];
					k--;
				}
			} else {
				if (j < 0 && k >= 0) {
					nums1[i] = nums2[i];
				}
			}
		}
	}
}
