import java.util.*;

public class FloydWarshall {
    public static double[][][] shortestPathMatrix(List<Edge> edges) {
        Map<Integer, Map<Integer, Double>> graph = new HashMap<>();

        for (Edge e : edges) {
            graph.putIfAbsent(e.from, new HashMap<>());
            graph.get(e.from).put(e.to, e.weight);
        }

        int n = graph.size();

        double[][][] dp = new double[n + 1][n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph.get(i) != null && graph.get(i).containsKey(j)) {
                    dp[0][i][j] = graph.get(i).get(j);
                } else {
                    dp[0][i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    dp[i][j][k] = Math.min(dp[i - 1][j][k], dp[i - 1][j][i] + dp[i - 1][i][k]);
                }
            }
        }

        return dp;
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
