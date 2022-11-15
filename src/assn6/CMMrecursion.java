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

            int answer = cmmRecursion(numArray, 1, n);
            System.out.println(answer);
        }
    }

    static int cmmRecursion(int[] nums, int i, int j) {
        if (i == j)
            return 0;

        int minMultNUm = MAX_SIZE;

        for (int k = i; k <= j - 1; k++) {
            int multNum = cmmRecursion(nums, i, k) + cmmRecursion(nums,k + 1, j) + nums[i - 1] * nums[k] * nums[j];
            if (multNum < minMultNUm)
                minMultNUm = multNum;
        }

        return minMultNUm;
    }
}
