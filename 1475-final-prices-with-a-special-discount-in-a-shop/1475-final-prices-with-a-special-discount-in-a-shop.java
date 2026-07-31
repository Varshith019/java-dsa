class Solution {
    public static int[] nse(int[] nums){
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()>nums[i]){
                st.pop();
            }
            if(!st.isEmpty()) ans[i] = nums[i]-st.peek();
            else ans[i] = nums[i];

            st.push(nums[i]);
        }
       
        return ans;
    }
    public int[] finalPrices(int[] prices) {
        return nse(prices);

       
    }
}