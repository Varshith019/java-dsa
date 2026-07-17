class Solution {
    public static int fun(int i,int buy,int[] prices,int[][] dp){
        if(i>=prices.length) return 0;
        if(dp[i][buy]!=-1) return dp[i][buy];
        if(buy==1){
            return dp[i][buy] = Math.max(-prices[i]+fun(i+1,0,prices,dp),fun(i+1,1,prices,dp));
        }
        else {
            return dp[i][buy] =  Math.max(prices[i]+fun(i+2,1,prices,dp),fun(i+1,0,prices,dp));
        }
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+2][2];
        for(int buy=0;buy<=1;buy++){
            dp[n][buy] = 0;
        }
        for(int i=n-1;i>=0;i--){
           for(int buy=0;buy<=1;buy++){
               if(buy==1){
                 dp[i][buy] = Math.max(-prices[i]+dp[i+1][0],dp[i+1][1]);
               }
               else {
                dp[i][buy] = Math.max(prices[i]+dp[i+2][1],dp[i+1][0]);
               }
           }
        }
        return dp[0][1];
    }
}