package assn5;

import java.util.Scanner;

public class QuickSort {
    static final int MAX_SIZE = 1000;
    static int swapHoareNum, swapLomutoNum, cmpHoareNum, cmpLomutoNum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTestcase = sc.nextInt();

        for (int i = 0; i < numTestcase; i++) {
            int numData = sc.nextInt();
            int[] dataArray1 = new int[MAX_SIZE];
            int[] dataArray2 = new int[MAX_SIZE];

            for (int j = 0; j < numData; j++) {
                dataArray1[j] = dataArray2[j] = sc.nextInt();
            }

            swapHoareNum = swapLomutoNum = cmpHoareNum = cmpLomutoNum = 0;
            quickSortHoare(dataArray1, 0, numData - 1);
            quickSortLomuto(dataArray2, 0, numData - 1);
            System.out.println(swapHoareNum + " " + swapLomutoNum + " " + cmpHoareNum + " " + cmpLomutoNum);
        }
    }

    static void quickSortHoare(int[] dataArray, int low, int high) {
        if (high > low) {
            int pivotPos = partitionHoare(dataArray, low, high);
            quickSortHoare(dataArray, low, pivotPos);
            quickSortHoare(dataArray, pivotPos + 1, high);
        }
    }

    static int partitionHoare(int[] dataArray, int low, int high) {
        int pivot = dataArray[low];
        int i = low - 1;
        int j = high + 1;

        while(true) {
            while(dataArray[++i] < pivot) {
                cmpHoareNum++;
            }
            while(dataArray[--j] > pivot) {
                cmpHoareNum++;
            }
            cmpHoareNum += 2;

            if(i < j) {
                int tmp = dataArray[i];
                dataArray[i] = dataArray[j];
                dataArray[j] = tmp;
                swapHoareNum++;
            } else {
                return j;
            }
        }
    }

    static void quickSortLomuto(int[] dataArray, int low, int high) {
        if (high > low) {
            int pivotPos = partitionLomuto(dataArray, low, high);
            quickSortLomuto(dataArray, low, pivotPos - 1);
            quickSortLomuto(dataArray, pivotPos + 1, high);
        }
    }

    static int partitionLomuto(int[] dataArray, int low, int high) {
        int pivot = dataArray[low];
        int j = low;

        for (int i = low + 1; i <= high; i++) {
            if (dataArray[i] < pivot) {
                j++;
                int tmp = dataArray[i];
                dataArray[i] = dataArray[j];
                dataArray[j] = tmp;
                swapLomutoNum++;
            }
            cmpLomutoNum++;
        }

        int pivotPos = j;
        dataArray[low] = dataArray[pivotPos];
        dataArray[pivotPos] = pivot;
        swapLomutoNum++;

        return pivotPos;
    }

}
