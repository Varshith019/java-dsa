class Solution {
    public int fib(int n,int[] dp){
        if(n==1 ||n==0) return 1;
        if(dp[n]!=-1)  {
            return dp[n];
        }
        dp[n] =  fib(n-1,dp)+fib(n-2,dp);
        return dp[n];
    }
    public int tab(int n,int[] dp){
        dp[0]  = 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
        dp[i] = dp[i-1]+dp[i-2]; 
        }
        return dp[n];
    }
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        
        
        return tab(n,dp);
    }
}