import java.util.*;

public class BellmanFord {
    public static List<Integer> shortestPathSequence(List<Edge> edges, int s, int t) {
        Map<Integer, List<Edge>> reversedGraph = new HashMap<>();

        for (Edge e : edges) {
            reversedGraph.putIfAbsent(e.to, new ArrayList<>());
            reversedGraph.get(e.to).add(e);
        }

        int n = reversedGraph.size();

        double[][] dp = new double[n][n];
        int[] prev = new int[n];

        for (int i = 0; i < n; i++) {
            dp[0][i] = Integer.MAX_VALUE;
        }

        dp[0][s] = 0;

        for (int i = 1; i < n - 1; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = dp[i - 1][j];

                for (Edge e : reversedGraph.get(j)) {
                    if (dp[i][j] > dp[i - 1][e.from] + e.weight) {
                        dp[i][j] = dp[i - 1][e.from] + e.weight;
                        prev[e.to] = e.from;
                    }
                }
            }
        }

        List<Integer> path = new ArrayList<>();
        path.add(t);
        int lastNode = t;

        while (lastNode != s) {
            path.add(prev[t]);
            lastNode = prev[t];
        }

        Collections.reverse(path);

        return path;
    }

    public static class Edge {
        int from;
        int to;
        double weight;

        public Edge(int from, int to, double weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
}
