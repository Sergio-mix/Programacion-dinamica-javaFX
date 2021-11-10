package co.edu.unbosque.programacindinmicajava.model;

import co.edu.unbosque.programacindinmicajava.controller.Main;

public class Binomial {

    public static int [][] getBinomialCoefficient(int n, int m) {

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
        Main.coeficienteBinomial= bc[n][m];
        return bc;
    }

    public static void printBinomialCoefficients(int[][] bc, int n) {

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.printf("%5d", bc[i][j]);
            }
            System.out.println();
        }
    }




}
