class Solution {
    public int mini(int n,int[] cost,int[] dp){
        if (n == 0 || n == 1)
            return 0;
        if(dp[n]!=-1) return dp[n];
        int one = cost[n-1]+mini(n-1,cost,dp);
        int two = Integer.MAX_VALUE;
        if(n>1){
         two = cost[n-2]+mini(n-2,cost,dp);
        }
        dp[n] = Math.min(one,two);
        return dp[n];
    }
    public int minCostClimbingStairs(int[] cost) {
      int n = cost.length;
      int[] dp = new int[n+1];
      Arrays.fill(dp,-1);
      
      return mini(n,cost,dp);
    }
}