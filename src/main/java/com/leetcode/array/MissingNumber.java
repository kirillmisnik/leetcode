package com.leetcode.array;

import java.util.Arrays;

public class MissingNumber {
    public static void main(String[] args) {
        System.out.println(new Solution().missingNumber1(new int[]
                {3,0,1}
        ));
        System.out.println(new Solution().missingNumber1(new int[]
                {0,1}
        ));
        System.out.println(new Solution().missingNumber1(new int[]
                {9,6,4,2,3,5,7,0,1}
        ));
    }

    static class Solution {
        public int missingNumber(int[] nums) {
            int n = nums.length;
            Arrays.sort(nums);

            if (nums[n - 1] != n) {
                return nums[n - 1] + 1;
            }

            for (int i = n - 1; i > 0; i--) {
                if ((nums[i] - nums[i - 1] != 1)) {
                    return nums[i - 1] + 1;
                }
            }

            return 0;
        }

        public int missingNumber1(int[] nums) {
            return (nums.length * (nums.length + 1) / 2) - Arrays.stream(nums).sum();
        }

        public int missingNumber2(int[] nums) {
            return (nums.length * (nums.length + 1) / 2) - Arrays.stream(nums).sum();
        }
    }
}
