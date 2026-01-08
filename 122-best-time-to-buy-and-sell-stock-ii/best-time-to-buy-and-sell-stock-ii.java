class Solution {
    public int maxProfit(int[] prices) {
        int priceslen = prices.length;
        int maximumProfit = 0;
        
        for (int i = 1; i < priceslen; i++) {
            maximumProfit += Math.max(0, prices[i] - prices[i - 1]);
        }
        return maximumProfit;
    }
}