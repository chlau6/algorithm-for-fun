public class ExtendedEuclidAlgorithm {
    public static ResultSet solution(int x, int y) {
        if (y == 0) return new ResultSet(x, 1, 0);

        ResultSet result = solution(y, x % y);

        System.out.println(result.d + " " + result.alpha + " " + result.beta + " " + x + " " + y);

        return new ResultSet(result.d, result.beta, result.alpha - (x / y) * result.beta);
    }

    public static void main(String[] args) {
        ResultSet result = ExtendedEuclidAlgorithm.solution(25, 11);

        System.out.println(result.d + " " + result.alpha + " " + result.beta);
    }

    static class ResultSet {
        int d;
        int alpha;
        int beta;

        ResultSet(int d, int alpha, int beta) {
            this.d = d;
            this.alpha = alpha;
            this.beta = beta;
        }
    }
}
