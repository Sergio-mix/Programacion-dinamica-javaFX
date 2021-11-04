package co.edu.unbosque.programacindinmicajava.model;

import java.util.Scanner;

public class ViajeroFuerzaBruta {
    static int[][] a = new int[5][5];
    static int[] bestWay = new int[6];
    static int min = 99999999;
    static int sum = 0;
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        /**
         * Suponiendo que a es el punto 1, b es el punto 2, c es el punto 3 y d es el punto 4
         * 1 2 2
         * 1 3 5
         * 1 4 7
         * 2 3 8
         * 2 4 3
         * 3 4 1
         * */
        for (int i = 1; i < 7; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            int z = in.nextInt();
            a[x][y] = z;
            a[y][x] = z;
        }
        for (int i = 2; i < a.length; i++) {
            for (int j = 2; j < a.length; j++) {
                if (j != i) {
                    for (int k = 2; k < a.length; k++) {
                        if (k != i && k != j) {
                            sum = a[1][i] + a[i][j]  + a[j][k] + a[k][1];
                            if (min > sum) {
                                min = sum;
                                bestWay[1] = 1;
                                bestWay[2] = i;
                                bestWay[3] = j;
                                bestWay[4] = k;
                                bestWay[5] = 1;
                            }
                        }
                    }
                }
            }
        }
        for (int i = 1; i < bestWay.length-1; i++) {
            System.out.print(bestWay[i] + "-->");
        }
        System.out.println(bestWay[bestWay.length-1]);
        System.out.println(min);
    }
}
