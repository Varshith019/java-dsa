class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n==1) return 0;
        int l = 0;
        int r = n-1;
        
        if(nums[0]>nums[1]) return 0;
        if(nums[n-1]>nums[n-2]) return n-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(nums[mid]>nums[mid+1] && nums[mid]>nums[mid-1]){
                return mid;
            }
            else if(nums[mid]<nums[mid+1]) {
                l = mid+1;
            }
            else {
                r = mid-1;
            }
        }
        return 0;
    }
}