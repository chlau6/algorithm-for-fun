import java.util.Arrays;

public class MaximumContiguousSubsequenceSum {
    public static void solution(int[] a, int n) {
        int[] maxSum = new int[n + 1];
        int localLength = 0;
        int maxLength = 0;
        int lastIndex = 0;

        for (int i = 1; i <= n; i++) {
            if (maxSum[i - 1] + a[i - 1] < 0) {
                localLength = 0;
            } else {
                maxSum[i] += a[i - 1];
                if (++localLength > maxLength) {
                    maxLength = localLength;
                    lastIndex = i - 1;
                }
            }
        }

        int[] result = new int[maxLength];

        for (int i = maxLength - 1; i >= 0; i--) {
            result[i] = a[lastIndex--];
        }

        System.out.println(maxSum[n]);
        System.out.println(Arrays.toString(result));
    }

    public static void main(String[] args) {
        MaximumContiguousSubsequenceSum.solution(new int[]{5, 15, -30, 10, -5, 40, 10}, 7);
    }
}

/*
Exercises 6.1
 */
