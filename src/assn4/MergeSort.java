package assn4;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    static final int MAX_SIZE = 1000;
    static int[] dataArray;
    static int num;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTestcase = sc.nextInt();

        for (int i = 0; i < numTestcase; i++) {
            int numData = sc.nextInt();
            dataArray = new int[MAX_SIZE];

            for (int j = 0; j < numData; j++) {
                dataArray[j] = sc.nextInt();
            }

            num = 0;
            mergeSort(0, numData - 1);
            System.out.println(num);
        }
    }

    static void mergeSort(int low, int high) {
        if (low == high) {
            return;
        }

        int mid = (low + high) / 2;
        mergeSort(low, mid);
        mergeSort(mid + 1, high);
        merge(low, mid, high);
    }

    static void merge(int low, int mid, int high) {
        int[] tmp = new int[MAX_SIZE];
        if (high + 1 - low >= 0)
            System.arraycopy(dataArray, low, tmp, low, high + 1 - low);

        int i = low;
        int j = mid+1;
        int k = low;
        while(i <= mid && j <= high) {
            if (tmp[i] <= tmp[j])
                dataArray[k++] = tmp[i++];
            else
                dataArray[k++] = tmp[j++];
            num++;
        }

        while(i<=mid)
            dataArray[k++] = tmp[i++];
        while(j<=high)
            dataArray[k++] = tmp[j++];
    }
}
