class Solution {
    public int fun(int i,int[] nums,int[] dp){
        if(i<0) return 0;
        if(dp[i]!=-1) return dp[i];
        int take = nums[i]+fun(i-2,nums,dp);
        int ntake = 0+fun(i-1,nums,dp);
        return dp[i] = Math.max(take,ntake);


    }
    public int rob(int[] nums) {
       int n = nums.length;
       int[] dp = new int[n+1];
       Arrays.fill(dp,-1);
       return fun(n-1,nums,dp);

    }
}