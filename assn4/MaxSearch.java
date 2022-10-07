package assn4;

import java.util.Scanner;

public class MaxSearch {
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

            System.out.println(maxSearch(dataArray,0, numData - 1));
        }
    }

    static int maxSearch(int[] dataArray, int low, int high) {
        if(low == high) {
            return dataArray[low];
        }

        int mid = (low + high) / 2;
        int left = maxSearch(dataArray, low, mid);
        int right = maxSearch(dataArray, mid + 1, high);

        return Math.max(left, right);
    }
}
