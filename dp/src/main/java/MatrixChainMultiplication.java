public class MatrixChainMultiplication {
    public static void solution(int[] m) {
        int n = m.length - 1;
        int[][] dp = new int[n + 1][n + 1];

        for (int s = 1; s <= n - 1; s++) {
            for (int i = 1; i <= n - s; i++) {
                int j = i + s;

                dp[i][j] = Integer.MAX_VALUE;

                for (int l = i; l <= j - 1; l++) {
                    int curr = m[i - 1] * m[l] * m[j] + dp[i][l] + dp[l + 1][j];

                    dp[i][j] = Math.min(dp[i][j], curr);
                }
            }
        }

        System.out.println(dp[1][n]);
    }

    public static void main(String[] args) {
        int[] chains = new int[] {30, 35, 15, 5, 10, 20, 25};
        solution(chains);
    }
}
