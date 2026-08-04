class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int leftmax = 1;
        int rightmax = 1;
        int max = nums[0];
        for(int i=0;i<n;i++){
        
        //front side product value
        leftmax*=nums[i];
        //from backside product value
        rightmax*=nums[n-1-i];
        max = Math.max(max,Math.max(leftmax,rightmax));
        leftmax = leftmax==0?1:leftmax;
        rightmax = rightmax==0?1:rightmax;
        }
        return max;
    }
}