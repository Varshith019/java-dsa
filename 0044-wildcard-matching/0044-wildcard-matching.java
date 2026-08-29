class Solution {
    public boolean fun(String s1,String s2,int i,int j,int[][] dp){
        if(i<0 && j<0) return true;
        if(j<0 && i>=0) return false;
        if(i<0 && j>=0) { 
            for(int k=j;k>=0;k--){
                if(s2.charAt(k)!='*') return false;
            }
            return true;
        }
       if(dp[i][j]!=-1) {
        return dp[i][j] ==1;
       }
       boolean answer = false;
       if(s1.charAt(i)==s2.charAt(j) || s2.charAt(j)=='?'){
         answer = fun(s1,s2,i-1,j-1,dp);
       }
       if(s2.charAt(j)=='*'){
          answer = fun(s1,s2,i-1,j,dp)||fun(s1,s2,i,j-1,dp);
       }
       if(answer){
        dp[i][j] = 1;
       }
       else {
        dp[i][j] = 0;
       }
       return answer;
    }
    public boolean isMatch(String s, String p) {
       int n = s.length();
       int m = p.length();
       int[][] dp = new int[n+1][m+1];
       for(int[] row:dp){
        Arrays.fill(row,-1);
       }
       return fun(s,p,n-1,m-1,dp);
    }
}