package assn6;

import java.util.Scanner;

public class CMMdp {
    static final int MAX_SIZE = 100000;
    static int[][] P;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTestcase = sc.nextInt();

        for (int i = 0; i < numTestcase; i++) {
            int n = sc.nextInt();
            P = new int[n + 1][n + 1];
            int[] numArray = new int[MAX_SIZE];

            for (int j = 0; j < n + 1; j++) {
                numArray[j] = sc.nextInt();
            }

            int answer = cmmDP(numArray, n);
            order(1, n);
            System.out.println();
            System.out.println(answer);
        }
    }

    static int cmmDP(int[] nums, int n) {
        int[][] M = new int[n + 1][n + 1];
        P = new int[n + 1][n + 1];

        for (int diagonal = 1; diagonal <= n - 1; diagonal++) {
            for (int i = 1; i <= n - diagonal; i++) {
                int j = i + diagonal;
                int minMultNum = MAX_SIZE;
                int minIdx = 0;

                for (int k = i; k <= j - 1; k++) {
                    int multNum = M[i][k] + M[k + 1][j] + nums[i - 1] * nums[k] * nums[j];
                    if (multNum < minMultNum) {
                        minMultNum = multNum;
                        minIdx = k;
                    }
                }
                M[i][j] = minMultNum;
                P[i][j] = minIdx;
            }
        }

        return M[1][n];
    }

    static void order(int i, int j) {
        if(i == j)
            System.out.print("M" + i);
        else {
            int k = P[i][j];
            System.out.print("(");
            order(i, k);
            order(k + 1, j);
            System.out.print(")");
        }
    }

}
