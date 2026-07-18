class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int[] parent = new int[n];
        int maxi = 1;
        int last = 0;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            parent[i] = i;
            for(int prev=0;prev<i;prev++){
                if(nums[i]%nums[prev]==0 && 1+dp[prev]>dp[i]){
                    dp[i] = dp[prev]+1;
                    parent[i] = prev;
                }
            }
            if(dp[i]>maxi){
                maxi = dp[i];
                last = i;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        while(parent[last]!=last){
            list.add(nums[last]);
            last = parent[last];
            
        }
        list.add(nums[last]);
        Collections.reverse(list);
        return list;
    }
}