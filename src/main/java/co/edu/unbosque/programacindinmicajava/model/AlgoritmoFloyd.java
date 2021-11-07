package co.edu.unbosque.programacindinmicajava.model;

public class AlgoritmoFloyd {

    public AlgoritmoFloyd() {

    }

    public static int[][] initial(int n, int m, int[][] e) {
        try {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (i == j) {
                        e[i][j] = 0;
                    } else {
                        e[i][j] = 99999999;
                    }
                }
            }
            return e;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public static int[][] floyd(int n, int[][] e) {
        try {
            for (int k = 1; k <= n; k++) {
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= n; j++) {
                        if (e[i][j] > e[i][k] + e[k][j]) {
                            e[i][j] = e[i][k] + e[k][j];
                        }
                    }
                }
            }
            return e;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

}