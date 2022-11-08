package assn3;

import java.util.Arrays;
import java.util.Scanner;

public class FastFibonacci {

    static int[][] zero = {{1, 0}, {0, 1}};
    static int[][] base = {{1, 1}, {1, 0}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTestcase = sc.nextInt();

        for (int i = 0; i < numTestcase; i++) {
            int data = sc.nextInt();
            System.out.println(ffibo(data, 0, zero, base)[1][0]);
        }
    }

    static int[][] ffibo(int n, int k, int[][] matrix, int[][] tmp) {
        if (Math.pow(2, k) > n){
            return matrix;
        }
        if ((n & (1 << k)) != 0) {
            matrix = mult(matrix, tmp);
        }

        return ffibo(n, ++k, matrix, mult(tmp, tmp));
    }

    static int[][] mult(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for (int i = 0; i < arr1.length; ++i) {
            for (int j = 0; j < arr2[0].length; ++j) {
                for (int k = 0; k < arr1[0].length; ++k) {
                    answer[i][j] += (arr1[i][k] * arr2[k][j]);
                    answer[i][j] = answer[i][j] % 1000;
                }
            }
        }

        return answer;
    }

}