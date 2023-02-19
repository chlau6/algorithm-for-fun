public class ChangeMaking2 {
    public static void solution(int[] coins, int v) {
        int n = coins.length;
        boolean[][] dp = new boolean[n + 1][v + 1];
        dp[0][0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= v; j++) {
                int coin = coins[i - 1];

                if (coin <= j) {
                    dp[i][j] = dp[i - 1][j - coin] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[n][v]);
    }

    public static void main(String[] args) {
        int[] coins = new int[] {1, 5, 10, 20};
        solution(coins, 16);
    }
}

/*
Exercise 6.18
 */