class Solution {
    public static int f(int ind,int prev,int[] nums,int[][] dp){
        if(ind==nums.length) return 0;
        if(dp[ind][prev+1]!=-1) return dp[ind][prev+1];
        int nottake = 0+f(ind+1,prev,nums,dp);

        int take = Integer.MIN_VALUE;
        if(prev==-1 || nums[ind]>nums[prev]){
             take = 1+f(ind+1,ind,nums,dp);
             
        }
        return dp[ind][prev+1] = Math.max(nottake,take);


    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return f(0,-1,nums,dp);
    }
}