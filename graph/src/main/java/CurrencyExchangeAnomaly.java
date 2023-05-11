import java.util.ArrayList;
import java.util.List;

public class CurrencyExchangeAnomaly {
    public static void main(String[] args) {
        String[] currencies = new String[] {"usd", "eur", "gbp", "chf", "cad"};
        double[][] rates = new double[5][5];

        // add testcase for your own

        List<FloydWarshall.Edge> edges = new ArrayList<>();

        int n = rates.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                edges.add(new FloydWarshall.Edge(i, j, -Math.log(rates[i][j])));
            }
        }

        double[][][] shortestPathMatrix = FloydWarshall.shortestPathMatrix(edges);

        for (int i = 0; i < n; i++) {
            if (shortestPathMatrix[n][i][i] < 0) {
                System.out.println("cycle found");
                break;
            }
        }

        System.out.println("no cycle");
    }
}

/*
Exercise 4.21b
 */
