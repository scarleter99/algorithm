package assn4;

import java.util.Scanner;

public class MaxContiSubseqSum {
    static final int MAX_SIZE = 1000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTestcase = sc.nextInt();

        for (int i = 0; i < numTestcase; i++) {
            int numData = sc.nextInt();
            int[] dataArray = new int[MAX_SIZE];

            for (int j = 0; j < numData; j++) {
                dataArray[j] = sc.nextInt();
            }

            int max = mcss(dataArray, 0, numData - 1);
            if (max < 0) {
                max = 0;
            }

            System.out.println(max);
        }
    }

    static int mcss(int[] dataArray, int low, int high) {
        if (low == high)
            return dataArray[low];

        int mid = (low + high) / 2;
        int left = mcss(dataArray, low, mid);
        int right = mcss(dataArray, mid + 1, high);
        int center = centerSum(dataArray, low, mid, high);

        return Math.max(Math.max(left,right),center);
    }

    static int centerSum(int[] dataArray, int low, int mid, int high) {
        int left = 0, right = 0;
        int leftMax = dataArray[mid], rightMax = dataArray[mid + 1];

        for (int i = mid; i >= low; i--) {
            left += dataArray[i];
            leftMax = Math.max(leftMax, left);
        }

        for (int i = mid + 1; i <= high; i++) {
            right += dataArray[i];
            rightMax = Math.max(rightMax, right);
        }

        return leftMax + rightMax;
    }
}
