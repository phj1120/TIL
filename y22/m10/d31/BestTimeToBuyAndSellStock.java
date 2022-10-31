package y22.m10.d31;

public class BestTimeToBuyAndSellStock {
}

class Solution {
    public int maxProfit(int[] prices) {
        int maxPrice = 0;

        int buyDay = 0;
        int sellDay = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[buyDay] >= prices[i]) {
                buyDay = i;
                sellDay = i;
            } else {
                sellDay = i;
                int nowPrice = prices[sellDay] - prices[buyDay];
                maxPrice = Math.max(nowPrice, maxPrice);
            }
        }
        return maxPrice;
    }
}