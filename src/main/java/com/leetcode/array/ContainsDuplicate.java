package com.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ContainsDuplicate {
    public static void main(String[] args) {
        System.out.println(new Solution().containsDuplicate(
                new int[]{1, 2, 3, 1}
        ));
        System.out.println(new Solution().containsDuplicate(
                new int[]{1, 2, 3, 4}
        ));
        System.out.println(new Solution().containsDuplicate(
                new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}
        ));
    }

    static class Solution {
        public boolean containsDuplicate(int[] nums) {

            Set<Integer> set = new HashSet<>();
            for (Integer num : nums) {
                if (set.contains(num)) {
                    return true;
                }
                set.add(num);
            }

            return false;
        }

        public boolean containsDuplicate2(int[] nums) {
            return Arrays.stream(nums).boxed().collect(Collectors.toCollection(HashSet::new)).size() != nums.length;
        }
    }
}
