import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZeroOneKnapsackRepeat {
    public static void solution(int[] w, int[] v, int capacity) {
        int n = w.length;
        int[] dp = new int[capacity + 1];
        int[] set = new int[capacity + 1];

        for (int i = 0; i <= capacity; i++) {
            for (int j = 1; j <= n; j++) {
                int weight = w[j - 1];
                int value = v[j - 1];

                if (weight <= i && dp[i] < dp[i - weight] + value) {
                    dp[i] = dp[i - weight] + value;
                    set[i] = j;
                }
            }
        }

        System.out.println(dp[capacity]);

        int i = capacity;
        List<Integer> object = new ArrayList<>();

        while (i > 0 && set[i] > 0) {
            object.add(set[i]);
            i -= w[set[i] - 1];
        }

        System.out.println(object);
    }

    public static void main(String[] args) {
        int[] w = new int[] {15, 12, 10, 5};
        int[] v = new int[] {15, 10, 8, 1};
        int capacity = 22;
        solution(w, v, capacity);
    }
}
