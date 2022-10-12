package assn5;

import java.util.Scanner;

public class MergeSortIterative {
    static final int MAX_SIZE = 1000;
    static int num;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTestcase = sc.nextInt();

        for (int i = 0; i < numTestcase; i++) {
            int numData = sc.nextInt();
            int[] dataArray = new int[MAX_SIZE];

            for (int j = 0; j < numData; j++) {
                dataArray[j] = sc.nextInt();
            }

            num = 0;
            mergeSortIterative(dataArray, numData);
            System.out.println(num);
        }
    }

    static void mergeSortIterative(int[] dataArray, int n) {
        int size = 1;

        while (size < n) {
            for (int i = 0; i < n; i += 2 * size) {
                int low = i;
                int mid = low + size -1;
                int high;
                if (i + 2 * size -1 < n - 1)
                    high = i + 2 * size -1;
                else
                    high = n - 1;

                if (mid >= n - 1)
                    break;
                merge(dataArray, low, mid, high);
            }
            size *= 2;
        }
    }

    static void merge(int[] dataArray, int low, int mid, int high) {
        int[] tmp = new int[MAX_SIZE];
        for(int i = low; i <= high; i++) {
            tmp[i] = dataArray[i];
        }

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
