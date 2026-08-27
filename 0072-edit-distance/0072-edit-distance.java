class Solution {
    public int fun(String s1,String s2,int i,int j,int[][] dp){
        if(j<0) return i;
        if(i<0) return j;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)){
            return  dp[i][j] = 0+fun(s1,s2,i-1,j-1,dp);
        }
        else {
        return dp[i][j] = Math.min(1+fun(s1,s2,i-1,j,dp),Math.min(1+fun(s1,s2,i-1,j-1,dp),1+fun(s1,s2,i,j-1,dp)));
        }
    }
    public int fun1(String s1,String s2){
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<=n;i++) dp[i][0] = i;
        for(int j=1;j<=m;j++) dp[0][j] = j;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.min(1+dp[i-1][j],Math.min(1+dp[i-1][j-1],1+dp[i][j-1]));
                }
            }
            
        }
        return dp[n][m];
    }
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return fun1(word1,word2);
    }
}