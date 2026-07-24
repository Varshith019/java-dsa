class Solution {
    public int longestSubarray(int[] nums) {
       int n = nums.length;
       int count = 0;
       int max = 0;
       int l = 0;
       for(int i=0;i<n;i++){
        if(nums[i]==0) count++;
        while(count>1){
            if(nums[l]==0) count--;
            l++;
        }
        max = Math.max(max,i-l);
       } 
       return max;
    }
}