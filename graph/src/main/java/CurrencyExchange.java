import java.util.ArrayList;
import java.util.List;

public class CurrencyExchange {
    public static void main(String[] args) {
        String[] currencies = new String[] {"usd", "eur", "gbp", "chf", "cad"};
        double[][] rates = new double[5][5];

        // add testcase for your own

        List<BellmanFord.Edge> edges = new ArrayList<>();

        int n = rates.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                edges.add(new BellmanFord.Edge(i, j, -Math.log(rates[i][j])));
            }
        }

        List<Integer> shortestPathSequence = BellmanFord.shortestPathSequence(edges, 1, 4);

        List<String> sequence = new ArrayList<>();

        for (int c : shortestPathSequence) {
            sequence.add(currencies[c]);
        }

        System.out.println(sequence);
    }
}

/*
Exercise 4.21a
 */
