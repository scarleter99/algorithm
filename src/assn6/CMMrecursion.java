package assn6;

import java.util.Scanner;

public class CMMrecursion {
    static final int MAX_SIZE = 100000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTestcase = sc.nextInt();

        for (int i = 0; i < numTestcase; i++) {
            int n = sc.nextInt();
            int[] numArray = new int[MAX_SIZE];

            for (int j = 0; j < n + 1; j++) {
                numArray[j] = sc.nextInt();
            }

            int answer = cmmRecurtion(numArray, n);
            System.out.println(answer);
        }
    }

    static int cmmRecurtion(int[] nums, int n) {
        int[][] M = new int[n + 1][n + 1];

        for(int diagonal = 1; diagonal <= n - 1; diagonal++) {
            for (int i = 1; i <= n - diagonal; i++) {
                int j = i + diagonal;
                int minMultNUm = MAX_SIZE;

                for (int k = i; k <= j - 1; k++) {
                    int multNum = M[i][k] + M[k + 1][j] + nums[i - 1] * nums[k] * nums[j];
                    if (multNum < minMultNUm)
                        minMultNUm = multNum;
                }
                M[i][j] = minMultNUm;
            }
        }

        return M[1][n];
    }
}
