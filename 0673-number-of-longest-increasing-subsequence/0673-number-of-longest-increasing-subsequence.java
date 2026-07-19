class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] cnt = new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(cnt,1);
        int max = 1;
        for(int i=0;i<n;i++){
            for(int prev=0;prev<i;prev++){
                if(nums[i]>nums[prev] && dp[prev]+1>dp[i]){
                    dp[i] = 1+dp[prev];
                    cnt[i] = cnt[prev];
                }
                else if(nums[i]>nums[prev] && dp[prev]+1==dp[i]){
                    cnt[i]+=cnt[prev];
                }
            }
            max = Math.max(max,dp[i]);
        }
        int ans = 0;
       for(int i=0;i<n;i++){
        if(dp[i]==max) ans+=cnt[i];
       }
       return ans;
    }
}