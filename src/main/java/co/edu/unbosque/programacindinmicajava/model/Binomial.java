package co.edu.unbosque.programacindinmicajava.model;

public class Binomial {

    public static long getBinomialCoefficient(int n, int m) {

        /** Matrix to hold Binomial Coefficients **/
        int[][] bc = new int[n + 1][n + 1];

        /** Filling first column of each row of matrix **/
        for (int i = 0; i <= n; i++) {
            bc[i][0] = 1;
        }

        /** Filling last column of each row of matrix **/
        for (int i = 0; i <= n; i++) {
            bc[i][i] = 1;
        }

        /** Computing rest columns **/
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                bc[i][j] = bc[i - 1][j - 1] + bc[i - 1][j];
            }
        }

        /** Printing Binomial Coefficients **/
        printBinomialCoefficients(bc, n);

        return bc[n][m];
    }

    private static void printBinomialCoefficients(int[][] bc, int n) {

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.printf("%5d", bc[i][j]);
            }
            System.out.println();
        }
    }


    static class BinomialCoefficientsTest {
        public static void main(String[] args) {
            int n = 5;
            int m = 2;

            System.out.printf("N :%d, M:%d, Binomial Coefficient: %d\n", n, m, getBinomialCoefficient(n, m));
        }
    }

}
