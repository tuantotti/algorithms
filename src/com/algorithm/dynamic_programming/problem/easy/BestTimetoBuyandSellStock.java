package com.algorithm.dynamic_programming.problem.easy;

/*link problem: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/*/
public class BestTimetoBuyandSellStock {
    private int prices[];

    public BestTimetoBuyandSellStock() {
        prices = new int[]{7, 1, 5, 3, 6, 4};
    }

    public int maxProfit() {
        int maxProfit = 0;
        int minPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice)
                minPrice = prices[i];
            if (prices[i] - minPrice > maxProfit)
                maxProfit = prices[i] - minPrice;
        }

        return maxProfit;
    }
}
