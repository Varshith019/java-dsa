class Solution {
    public int[] movezeros(int[] nums){
        int n = nums.length;
        int l = 0;
        for(int i=0;i<n;i++){
            if(nums[i]!=0){
                int temp = nums[i];
                nums[i] = nums[l];
                nums[l] = temp;
                l++;
            }
        }
        return nums;
    }
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        
        for(int i=1;i<n;i++){
           if(nums[i]==nums[i-1]){
             nums[i-1] = nums[i-1]*2;
             
             nums[i] = 0;
           }
        }
        return movezeros(nums);
    }
}