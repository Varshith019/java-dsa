class Solution {
    public int pivotIndex(int[] nums) {
       int total = 0;
       int n = nums.length;
       for(int num:nums) total+=num;

       int left = 0;
       for(int i=0;i<n;i++){
        if(total-left-nums[i]==left){
            return i;
        }
        left+=nums[i];
       }
     return -1;
    }
}