public class LongestCommonSubsequence {
    public static void solution(String s, String t, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[m][n]);
    }


    public static void main(String[] args) {
        solution("ATGCGT", "ACGGCGT", 6, 7);
    }
}

/*
Exercises 6.11
 */
