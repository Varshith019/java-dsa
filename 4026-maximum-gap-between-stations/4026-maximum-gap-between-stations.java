class Solution {
    public int maximumGap(String skill, String station) {
        int n = skill.length();
        int len = station.length();
        int[] right = new int[n];
        int[] left = new int[n];
        int l = 0;
        
        for(int i=0;i<len;i++){
            if(l<n && skill.charAt(l)==station.charAt(i)){
                left[l++] = i;
            }
        }
        int r = n-1;
        for(int i=len-1;i>=0;i--){
           if(r>=0 && station.charAt(i)==skill.charAt(r)){
              right[r--] = i;
           }
        }
        int ans = 0;
        for(int i=1;i<skill.length();i++){
            ans = Math.max(ans,right[i]-left[i-1]);
        }
         return ans;
    }
}