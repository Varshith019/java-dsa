class Solution {
    public boolean possible(int d,int[] nums,int k){
        int n = nums.length;
        int sum = 0;
        for(int i=0;i<n;i++){
            sum += (int) Math.ceil((double)nums[i]/d);
        }
        if(sum<=k) return true;
        else return false;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int max = 0;
        for(int i=0;i<nums.length;i++){
            max = Math.max(max,nums[i]);
        }
        int l = 1;
        int  r = max;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(possible(mid,nums,threshold)){
                r = mid-1;
            }
            else {
                l = mid+1;
            }
        }
        return l;
    }
}