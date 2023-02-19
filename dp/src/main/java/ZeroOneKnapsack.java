public class ZeroOneKnapsack {
    public static void solution(int[] w, int[] v, int capacity) {
        int n = w.length;
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacity; j++) {
                int weight = w[i - 1];
                int value = v[i - 1];
                if (weight <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight] + value);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[n][capacity]);
    }

    public static void main(String[] args) {
        int[] w = new int[] {15, 12, 10, 5};
        int[] v = new int[] {15, 10, 8, 1};
        int capacity = 22;
        solution(w, v, capacity);
    }
}
