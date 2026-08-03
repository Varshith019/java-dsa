class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int currmax =0;
        int maxi = 0;
        int currmin = 0;
        int mini = 0;
        for(int i=0;i<n;i++){
            currmax = Math.max(currmax+nums[i],nums[i]);
            maxi = Math.max(maxi,currmax);

            currmin = Math.min(currmin+nums[i],nums[i]);
            mini = Math.min(mini,currmin);
        }
        int a = Math.abs(maxi);
        int b = Math.abs(mini);
        System.out.print(a+" "+b);
        return Math.max(a,b);
    }
}