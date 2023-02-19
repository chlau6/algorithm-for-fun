public class ChangeMaking1 {
    public static void solution(int[] coins, int v) {
        boolean[] dp = new boolean[v + 1];
        dp[0] = true;

        for (int i = 1; i <= v; i++) {
            for (int coin : coins) {
                if (coin <= i && dp[i - coin]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        System.out.println(dp[v]);
    }

    public static void main(String[] args) {
        int[] coins = new int[] {1, 2, 5, 10};
        solution(coins, 27);
    }
}

/*
Exercise 6.17
 */