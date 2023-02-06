import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HotelStop {
    public static void solution(int[] a, int n) {
        int[] penalty = new int[n];
        int[] prevStop = new int[n];

        for (int i = 0; i < n; i++) {
            penalty[i] = (int) Math.pow((200 - a[i]), 2);
            prevStop[i] = 0;
            for (int j = 0; j < i; j++) {
                int splitPath = penalty[j] + (int) Math.pow(200 - (a[i] - a[j]), 2);
                if (splitPath < penalty[i]) {
                    penalty[i] = splitPath;
                    prevStop[i] = j + 1;
                }
            }
        }

        int i = n - 1;
        List<Integer> result = new ArrayList<>();

        while (i >= 0) {
            result.add(i + 1);
            i = prevStop[i] - 1;
        }

        Collections.reverse(result);

        System.out.println(penalty[n - 1]);
        System.out.println(result);
    }


    public static void main(String[] args) {
        HotelStop.solution(new int[]{190, 200, 420, 550, 660, 670}, 6);
    }
}

/*
Exercises 6.2
 */
