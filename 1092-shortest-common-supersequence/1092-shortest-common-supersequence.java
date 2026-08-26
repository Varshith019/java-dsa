class Solution {

    public static String print(
        int[][] dp, String s1, String s2, int n, int m
    ) {
        int i = n;
        int j = m;

        StringBuilder answer = new StringBuilder();

        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                answer.append(s1.charAt(i - 1));
                i--;
                j--;
            } 
            else if (dp[i - 1][j] > dp[i][j - 1]) {
                answer.append(s1.charAt(i - 1));
                i--;
            } 
            else {
                answer.append(s2.charAt(j - 1));
                j--;
            }
        }

        // Add all remaining characters from s1
        while (i > 0) {
            answer.append(s1.charAt(i - 1));
            i--;
        }

        // Add all remaining characters from s2
        while (j > 0) {
            answer.append(s2.charAt(j - 1));
            j--;
        }

        return answer.reverse().toString();
    }

    public static void fun(
        String s1, String s2, int n, int m, int[][] dp
    ) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(
                        dp[i - 1][j],
                        dp[i][j - 1]
                    );
                }
            }
        }
    }

    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[n + 1][m + 1];

        fun(str1, str2, n, m, dp);

        return print(dp, str1, str2, n, m);
    }
}