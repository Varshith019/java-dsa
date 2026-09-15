class Solution {
    public int lowerBound(int[] nums,int target){
        int l = 0;
        int r = nums.length-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(nums[mid]>=target){
                r = mid-1;
            }
            else {
                l = mid+1;
            }
        }
        return l;
    }
    public int upperBound(int[] nums,int target){
        int l = 0;
        int r = nums.length-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(nums[mid]<=target){
                l= mid+1;
            }
            else {
                r = mid-1;
            }
            
        }
        return r;
    }
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int one = lowerBound(nums,target);
        int two = upperBound(nums,target);
        if(nums.length==0 ||one>=n || nums[one]!=target) {
            one = -1;
        }
        if(nums.length==0 ||two<0 || nums[two]!=target){
            two = -1;
        }
        int[] arr = new int[2];
        arr[0] = one;
        arr[1] = two;
        return arr;
    }
}