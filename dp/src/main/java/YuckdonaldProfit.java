import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class YuckdonaldProfit {
    public static void solution(int[] p, int[] m, int n, int k) {
        int[] profit = new int[n];

        for (int i = 0; i < n; i++) {
            profit[i] = p[i];
            for (int j = 0; j < i; j++) {
                if (m[j] + k <= m[i]) {
                    profit[i] = Math.max(profit[i], profit[j] + p[i]);
                }

                profit[i] = Math.max(profit[i - 1], profit[i]);
            }
        }

        System.out.println(profit[n - 1]);
    }


    public static void main(String[] args) {
        int[] p = new int[]{30, 9, 13, 25, 23, 3, 10};
        int[] m = new int[]{1, 10, 16, 21, 22, 35, 38};
        int n = m.length;
        int k = 10;

        solution(p, m, n, k);
    }
}

/*
Exercises 6.3
 */
