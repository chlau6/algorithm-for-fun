import java.util.Arrays;

public class ChangeMaking3 {
    public static void solution(int[] coins, int v, int k) {
        int[] dp = new int[v + 1];
        Arrays.fill(dp, v + 1);
        dp[0] = 0;

        for (int i = 1; i <= v; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        System.out.println(dp[v] <= k);
    }

    public static void main(String[] args) {
        int[] coins = new int[] {5, 10};
        solution(coins, 55, 6);
    }
}

/*
Exercise 6.19
 */