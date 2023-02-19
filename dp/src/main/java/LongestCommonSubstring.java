public class LongestCommonSubstring {
    public static void solution(String s, String t, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        int result = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = s.charAt(i - 1) == t.charAt(j - 1) ? dp[i - 1][j - 1] + 1 : 0;
                result = Math.max(result, dp[i][j]);
            }
        }

        System.out.println(result);
    }


    public static void main(String[] args) {
        solution("abcdaf", "bcdf", 6, 4);
    }
}