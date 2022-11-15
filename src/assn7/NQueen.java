package assn7;

import java.util.Scanner;

public class NQueen {
    static final int MAX_SIZE = 100000;
    static int[] col;
    static boolean fin;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTestcase = sc.nextInt();

        for (int i = 0; i < numTestcase; i++) {
            fin = false;

            int n = sc.nextInt();
            col = new int[n];
            for (int j = 0; j < n && !fin; j++) {
                col[0] = j;
                nQueen(n, 0);
            }
        }
    }

    static void nQueen(int n, int row) {
        if (isPromising(row)) {
            if (row == n - 1) {
                for (int i = 0; i < n; i++)
                    System.out.print(col[i] + " ");
                System.out.println();
                fin = true;
            }
            else {
                for (int i = 0; i < n && !fin; i++) {
                    col[row + 1] = i;
                    nQueen(n, row + 1);
                }
            }
        }
    }

    static boolean isPromising(int row) {
        for(int k = 0; k < row; k++) {
            if(col[row] == col[k] || Math.abs(col[row] - col[k]) == row - k) {
                return false;
            }
        }

        return true;
    }
}