package com.leetcode.array;

public class BestTimeToBuyAndSellStock {
    static class Solution {
        public int maxProfit(int[] prices) {
            int buyCost = prices[0];
            int mostProfit = 0;

            for (int i = 1; i < prices.length; i++) {
                if (prices[i] < buyCost) {
                    buyCost = prices[i];
                } else if ((prices[i] - buyCost) > mostProfit) {
                    mostProfit = prices[i] - buyCost;
                }
            }
            return mostProfit;
        }
    }
    public static void main(String[] args) {
        System.out.println(new BestTimeToBuyAndSellStock.Solution()
                .maxProfit(new int[]{7,1,5,3,6,4})
        );
        System.out.println(new BestTimeToBuyAndSellStock.Solution()
                .maxProfit(new int[]{7,6,4,3,1})
        );
    }
}
