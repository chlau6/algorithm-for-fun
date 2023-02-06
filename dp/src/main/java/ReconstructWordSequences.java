import java.util.*;

public class ReconstructWordSequences {
    private static final Set<String> SET = Set.of("it", "was", "the", "best", "of", "times");

    public static void solution(String s, int n) {
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        Map<Integer, List<String>> map = new HashMap<>();
        map.put(0, new ArrayList<>());

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                String substring = s.substring(j, i);
                if (dp[j] && dict(substring)) {
                    dp[i] = true;
                    List<String> list = new ArrayList<>(map.get(j));
                    list.add(substring);
                    map.put(i, list);
                    break;
                }
            }
        }

        System.out.println(dp[n]);
        System.out.println(map.get(n));
    }

    private static boolean dict(String w) {
        return SET.contains(w);
    }

    public static void main(String[] args) {
        ReconstructWordSequences.solution("itwasthebestoftimes", 19);
    }
}

/*
Exercises 6.4
 */
