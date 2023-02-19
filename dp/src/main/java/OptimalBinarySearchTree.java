import java.util.Arrays;

public class OptimalBinarySearchTree {
    public static void solution(String[] words, double[] frequencies) {
        int n = words.length;

        double[][] dp = new double[n + 1][n + 1];

        for (int s = 1; s <= n; s++) {
            dp[s][s] = frequencies[s - 1];
        }

        for (int s = 1; s <= n; s++) {
            for (int i = 1; i <= n - s; i++) {
                int j = i + s;

                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k <= j; k++) {
                    double left = k > i ? dp[i][k - 1] : 0;
                    double right = k < j ? dp[k + 1][j] : 0;

                    dp[i][j] = Math.min(dp[i][j], left + right);
                }

                for (int k = i; k <= j; k++) {
                    dp[i][j] += frequencies[k - 1];
                }
            }
        }

        System.out.println(dp[1][n]);
    }

    public static void main(String[] args) {
        String[] words = new String[] {"begin", "do", "else", "end", "if", "then", "while"};
        double[] frequencies = new double[] {5, 40, 8, 4, 10, 10, 23};

        solution(words, frequencies);
    }
}

/*
Exercise 6.19
 */