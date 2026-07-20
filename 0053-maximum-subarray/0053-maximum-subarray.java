class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int first = -1;
        int last = -1;
        for(int i=0;i<nums.length;i++){
            if(sum==0) first = i;
            sum+=nums[i];
           if(max<sum){
             max = Math.max(max,sum);
             last = i;
           }
           //if(max<sum) max = sum;
            if(sum<0){
                sum = 0;

            }
        }
        System.out.print(first+" "+last);
        return max;
    }
}