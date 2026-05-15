class Solution {
    public int maxProfit(int[] prices) {
        int minp = prices[0];
        int p = 0;
        int x = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] < minp){
                minp = prices[i];
            }
            x = prices[i] - minp;
            if(x > p){
                p = x;
            }
        }
        return p;
    }
}
