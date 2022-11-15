package assn7;

import java.util.Scanner;

public class Sudoku {
    static final int MAX_SIZE = 100000;
    static int[][] grid;
    static boolean fin;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 4;
        int numTestcase = sc.nextInt();

        for (int i = 0; i < numTestcase; i++) {
            grid = new int[n][n];

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    grid[j][k] = sc.nextInt();
                }
            }

            sudoku();
        }
    }

    static void sudoku() {

    }

}
