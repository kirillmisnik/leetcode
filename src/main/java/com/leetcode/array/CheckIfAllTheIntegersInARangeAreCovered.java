package com.leetcode.array;

public class CheckIfAllTheIntegersInARangeAreCovered {
    static class Solution {
        public boolean isCovered(int[][] ranges, int left, int right) {
            boolean areCovered = false;
            while(right >= left) {
                for (int[] range : ranges) {
                    if (range[0] <= left && range[range.length - 1] >= left) {
                        areCovered = true;
                        break;
                    }
                    areCovered = false;
                }
                if (!areCovered) {
                    return false;
                }
                left++;
            }
            if (!areCovered) {
                return false;
            }

            return areCovered;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isCovered(
                new int[][]{{1, 2}, {3, 4}, {5, 6}}, 2, 5
        ));
        System.out.println(new Solution().isCovered(
                new int[][]{{1, 1}}, 1, 50
        ));
        System.out.println(new Solution().isCovered(
                new int[][]{{50, 50}}, 1, 50
        ));
        System.out.println(new Solution().isCovered(
                new int[][]{{36,50},{14,28},{4,31},{24,37},{13,36},{27,33},{23,32},{23,27},{1,35}}, 1, 50
        ));
    }
}
