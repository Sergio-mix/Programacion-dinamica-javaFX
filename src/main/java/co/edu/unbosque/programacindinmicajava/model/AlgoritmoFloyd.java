package co.edu.unbosque.programacindinmicajava.model;

public class AlgoritmoFloyd {

    public AlgoritmoFloyd(int n, int m, int[][] e) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == j) {
                    e[i][j] = 0;
                } else {
                    e[i][j] = 99999999;
                }
            }
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (e[i][j] > e[i][k] + e[k][j]) {
                        e[i][j] = e[i][k] + e[k][j];
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(e[i][j] + " ");
            }
            System.out.println();
        }
    }

}