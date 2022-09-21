package assn1;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {
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

            bubbleSort(Arrays.copyOf(dataArray, numData), numData);
            bubbleSortImproved1(Arrays.copyOf(dataArray, numData), numData);
            bubbleSortImproved2(Arrays.copyOf(dataArray, numData), numData);
            System.out.println();
        }
    }

    static void bubbleSort(int[] dataArray, int n) {
        int countCmpOps = 0;
        int countSwaps = 0;

        // Algorithm
        for (int pass = 0; pass < n; pass++) {
            for (int i = 1; i < n - pass; i++) {
                if (dataArray[i] < dataArray[i - 1]) {
                    int tmp = dataArray[i];
                    dataArray[i] = dataArray[i - 1];
                    dataArray[i - 1] = tmp;
                    countSwaps++;
                }
                countCmpOps++;
            }

            System.out.print(countCmpOps + " " + countSwaps + " ");
            //System.out.println(Arrays.toString(dataArray));
        }
    }

    static void bubbleSortImproved1(int[] dataArray, int n) {
        int countCmpOps = 0;
        int countSwaps = 0;

        // Algorithm
        for (int pass = 0; pass < n; pass++) {
            boolean swapped = false;
            for (int i = 1; i < n - pass; i++ ) {
                if (dataArray[i] < dataArray[i - 1]) {
                    int tmp = dataArray[i];
                    dataArray[i] = dataArray[i-1];
                    dataArray[i-1] = tmp;
                    swapped = true;
                    countSwaps++;
                }
                countCmpOps++;
            }
            if (!swapped) {
                break;
            }
        }

        System.out.print(countCmpOps + " " + countSwaps + " ");
        //System.out.println(Arrays.toString(dataArray));
    }

    static void bubbleSortImproved2(int[] dataArray, int n) {
        int countCmpOps = 0;
        int countSwaps = 0;

        // Algorithm
        int lastSwappedPos = n;
        while (lastSwappedPos > 0) {
            int swappedPos = 0;
            for (int i = 1; i < lastSwappedPos; i++ ) {
                if (dataArray[i] < dataArray[i - 1]) {
                    int tmp = dataArray[i];
                    dataArray[i] = dataArray[i-1];
                    dataArray[i-1] = tmp;
                    swappedPos = i;
                    countSwaps++;
                }
                countCmpOps++;
            }
            lastSwappedPos = swappedPos;
        }

        System.out.print(countCmpOps + " " + countSwaps + " ");
        //System.out.println(Arrays.toString(dataArray));
    }
}