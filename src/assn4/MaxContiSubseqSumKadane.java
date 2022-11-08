package assn4;

import java.util.Scanner;

public class MaxContiSubseqSumKadane {
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
            kadane(dataArray, numData);

        }
    }

    static void kadane(int[] dataArray, int n) {
        int[] lowArray = new int[n];
        int lowIdx = 0;
        for (int i = 1; i < n; i++) {
            if (dataArray[i] < dataArray[i] + dataArray[i - 1]) {
                dataArray[i] = dataArray[i] + dataArray[i - 1];
            } else {
                lowIdx = i;
            }
            lowArray[i] = lowIdx;
        }

        int maxNum = 0;
        int low = -1;
        int high = -1;
        for (int i = 0; i < n; i++) {
            if (dataArray[i] > maxNum) {
                maxNum = dataArray[i];
                high = i;
                low = lowArray[i];
            }
        }

        System.out.println((maxNum) + " " + low + " " + high);
    }
}
