class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] arr = new int[n];
        Arrays.fill(arr,-1);
        int win = 2*k+1;
        if(win>n) return arr;
        long sum = 0;
        int l = 0;
        for(int i=0;i<n;i++){
             sum+=nums[i];
        
           if(i-l+1==win){
              arr[l+k] = (int)(sum/ win);
              sum-=nums[l];
              l++;
           }
        }
        return arr;
    }
}