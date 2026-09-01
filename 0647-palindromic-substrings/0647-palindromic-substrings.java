class Solution {
    public static int countpalin(String s,int left,int right,int[][] dp){
        int count = 0;
        if(dp[left][right]!=-1) return dp[left][right];
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            count++;
            dp[left][right] = count;
            left--;
            right++;
        }
        return count;
            }
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        int[][] dp = new int[n+1][n+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        for(int i=0;i<n;i++){
            count+=countpalin(s,i,i,dp);
            count+=countpalin(s,i,i+1,dp);
        }
        return count;
    }
   
}