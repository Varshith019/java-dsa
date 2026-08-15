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
        int p1 = 1;
        int p2 = 1;
        for(int i=2;i<=n;i++){
        int curr = p1+p2;
        p2 = p1;
        p1 = curr; 
        }
        return p1;
    }
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        
        
        return tab(n,dp);
    }
}