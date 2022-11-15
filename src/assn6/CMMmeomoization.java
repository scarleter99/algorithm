package assn6;

import java.util.Scanner;

public class CMMmeomoization {
    static final int MAX_SIZE = 100000;
    static int[][] M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTestcase = sc.nextInt();

        for (int i = 0; i < numTestcase; i++) {
            int n = sc.nextInt();
            int[] numArray = new int[MAX_SIZE];
            M = new int[n + 1][n + 1];
            for (int j = 0; j < n + 1; j++)
                for (int k = 0; k < n + 1; k++)
                    M[j][k] = -1;

            for (int j = 0; j < n + 1; j++) {
                numArray[j] = sc.nextInt();
            }

            int answer = cmmMemoization(numArray, 1, n);
            System.out.println(answer);
        }
    }

    static int cmmMemoization(int[] nums, int i, int j) {
        if (i == j)
            return 0;
        else if (M[i][j] != -1) {
            return M[i][j];
        }

        int minMultNUm = MAX_SIZE;

        for (int k = i; k <= j - 1; k++) {
            int multNum = cmmMemoization(nums, i, k) + cmmMemoization(nums,k + 1, j) + nums[i - 1] * nums[k] * nums[j];
            if (multNum < minMultNUm)
                minMultNUm = multNum;
        }

        M[i][j] = minMultNUm;
        return minMultNUm;
    }

}
