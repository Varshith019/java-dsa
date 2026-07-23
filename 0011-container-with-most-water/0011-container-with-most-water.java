class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int max = 0;
        int l = 0;
        int r = n-1;
        while(l<r){
        if(height[l]<height[r]){
            max = Math.max(max,height[l]*(r-l));
            l++;
        }
        else {
            max = Math.max(max,height[r]*(r-l));
            r--;
        }
        }
        return max;
    }
}