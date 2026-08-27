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
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return fun(word1,word2,n-1,m-1,dp)+1;
    }
}