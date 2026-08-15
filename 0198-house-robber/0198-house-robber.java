class Solution {
    private int fun(int n,int[] nums,int[] dp){
        if(n<0) return 0;
        if(n==0) return nums[0];
        if(dp[n]!=-1) return dp[n];
        
        int pick = nums[n]+fun(n-2,nums,dp);
        int notpick = fun(n-1,nums,dp);
        return dp[n] = Math.max(pick,notpick);

    }
    public int fun1(int n,int[] nums,int[] dp){
        dp[0] = nums[0];
        for(int i=1;i<=n;i++){
            int pick = nums[i];
            if(i>1){
             pick +=dp[i-2];
            }
            int notpick = dp[i-1];
            dp[i] = Math.max(pick,notpick);
        }
        return dp[n];

    }
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        
        return fun1(n-1,nums,dp);
    }
}