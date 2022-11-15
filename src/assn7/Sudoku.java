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
            fin = false;
            grid = new int[n][n];

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    grid[j][k] = sc.nextInt();
                }
            }

            sudoku(n, 0, 0);
        }
    }

    static void sudoku(int n,int row, int col) {
        if(row >=n) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(grid[i][j] + " ");
                }

                System.out.println();
            }

            fin = true;
            return;
        }

        if (grid[row][col] != 0 && !fin) {
            if (col < n - 1)
                sudoku(n, row, col + 1);
            else
                sudoku(n, row + 1, 0);
            return;
        }

        for (int i = 1; i <= n && !fin; i++) {
            if (available(n, row, col, i)) {
                grid[row][col] = i;

                if (col < n - 1)
                    sudoku(n, row, col + 1);
                else
                    sudoku(n, row + 1, 0);
            }
        }
    }

    static boolean available(int n, int row, int col, int num) {
        for (int i = 0; i < n; i++) {
            if (num == grid[row][i] || num == grid[i][col])
                return false;
        }

        int rowMin, colMin;

        if (row / 2 == 0) {
            rowMin = 0;
        } else {
            rowMin = 2;
        }

        if (col / 2 == 0) {
            colMin = 0;
        } else {
            colMin = 2;
        }

        for (int i = rowMin; i <= rowMin + 1; i++)
            for (int j = colMin; j <= colMin + 1; j++)
                if (num == grid[i][j])
                    return false;

        return true;
    }

}
