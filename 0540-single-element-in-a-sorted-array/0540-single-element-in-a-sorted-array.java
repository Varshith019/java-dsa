class Solution {
    public static int ub(int[] nums,int key){
        int n = nums.length;
        int l = 0;
        int r = n-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(nums[mid]<=key){
                l = mid+1;
            }
            else {
                r = mid-1;
            }
        }
        return r;
    }
    public static int lb(int[] nums,int key){
        int n = nums.length;
        int l = 0;
        int r = n-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(nums[mid]>=key){
                r = mid-1;
            }
            else {
                l= mid+1;
            }
        }
        return l;
    }
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            int rep = ub(nums,nums[i])-lb(nums,nums[i])+1;
            if(rep==1) return nums[i];
        }
       return 0; 
    }
}