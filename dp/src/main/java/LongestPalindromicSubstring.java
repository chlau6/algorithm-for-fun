public class LongestPalindromicSubstring {
    public static void solution(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int left = 0;
        int maxLength = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                }

                if (dp[j][i] && i - j + 1 > maxLength) {
                    maxLength = i - j + 1;
                    left = j;
                }
            }
        }

        System.out.println(maxLength);
        System.out.println(s.substring(left, left + maxLength));

    }

    public static void main(String[] args) {
        String s = "ACGTGTCAAAATCG";
        solution(s);
    }
}