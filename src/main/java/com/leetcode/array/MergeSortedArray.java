package com.leetcode.array;

import java.util.Arrays;

public class MergeSortedArray {
    static class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int nums1Index = m - 1;
            int nums2Index = n - 1;
            int index = m + n - 1;

            while (nums2Index >= 0)
                nums1[index--] = nums1Index >= 0 && nums1[nums1Index] > nums2[nums2Index] ?
                        nums1[nums1Index--] : nums2[nums2Index--];
        }
    }
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        new MergeSortedArray.Solution()
                .merge(nums1, 3, nums2, 3);
        System.out.printf("nums1 = %s", Arrays.toString(nums1)
        );
    }
}
