package assn6;

import java.util.Scanner;

public class CMMdp {
    static final int MAX_SIZE = 100000;
    static int[][] M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTestcase = sc.nextInt();

        for (int i = 0; i < numTestcase; i++) {
            int n = sc.nextInt();
            int[] numArray = new int[MAX_SIZE];
            M = new int[n][n];

            for (int j = 0; j < n + 1; j++) {
                numArray[j] = sc.nextInt();
            }

            int answer = cmmDP(numArray, 1, n);
            System.out.println(answer);
        }
    }

    static int cmmDP(int[] nums, int i, int j) {
        if (i == j)
            return 0;

        int minMultNUm = MAX_SIZE;

        for (int k = i; k <= j - 1; k++) {
            int multNum = cmmDP(nums, i, k) + cmmDP(nums,k + 1, j) + nums[i - 1] * nums[k] * nums[j];
            if (multNum < minMultNUm)
                minMultNUm = multNum;
        }

        return minMultNUm;
    }
}
