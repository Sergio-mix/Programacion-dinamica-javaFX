package co.edu.unbosque.programacindinmicajava.model;

public class Matriz {
    public int[][] matrixChainM(int[] p, int[][] m, int[][] s) {
        int n = p.length - 1;


        for (int i = 1; i <= n; i++) {
            m[i][i] = 0;
        }

        for (int r = 2; r <= n; r++) {
            for (int i = 1; i <= n - r + 1; i++) {
                int j = i + r - 1;
                m[i][j] = m[i + 1][j] + p[i - 1] * p[i] * p[j];
                s[i][j] = i;
                for (int k = i + 1; k < j; k++) {
                    int t = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (t < m[i][j]) {
                        m[i][j] = t;
                        s[i][j] = k;
                    }
                }
            }
        }
        return m;
    }
    public int[][] matrixChainS(int[] p, int[][] m, int[][] s) {
        int n = p.length - 1;


        for (int i = 1; i <= n; i++) {
            m[i][i] = 0;
        }

        for (int r = 2; r <= n; r++) {
            for (int i = 1; i <= n - r + 1; i++) {
                int j = i + r - 1;
                m[i][j] = m[i + 1][j] + p[i - 1] * p[i] * p[j];
                s[i][j] = i;
                for (int k = i + 1; k < j; k++) {
                    int t = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (t < m[i][j]) {
                        m[i][j] = t;
                        s[i][j] = k;
                    }
                }
            }
        }
        return m;
    }

    public void traceback(int[][] s, int i, int j) {
        if (i == j) {
            return;
        }
        traceback(s, i, s[i][j]);
        traceback(s, s[i][j] + 1, j);
//			System.out.println("Multiply    A" + i + "," + s[i][j] + "and A" + (s[i][j] + 1) + "," + j);
    }
    public int[][] matrix_multiply(int[][] a,int [][] b,int f1, int c2,int c1) {

        int c[][] = new int[f1][c2] ;
        for (int i = 0; i < f1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int h = 0; h < c1; h++) {
                    c[i][j] += a[i][h] * b[h][j];
                }
            }

        }

        return c;
    }
}
