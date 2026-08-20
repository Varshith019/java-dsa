class Solution {
    public static int pal(String s,String t){
        int n = s.length();
        int m = t.length();
        int[] prev = new int[m+1];
        
        for(int j=0;j<=m;j++) prev[j] = 0;
        for(int i=1;i<=n;i++){
            int[] curr = new int[m+1];
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    curr[j] = 1+prev[j-1];
                }
                else {
                    curr[j] = Math.max(prev[j],curr[j-1]);
                }
            }
            prev = curr;
        }
        return prev[m];
    }
    public int longestPalindromeSubseq(String s) {
    String t = new StringBuilder(s).reverse().toString();
     return pal(s,t);
    }
}