package assn7;

import java.util.Scanner;

public class HeapSort {
    static final int MAX_SIZE = 10000;
    static int numCom = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTestcase = sc.nextInt();

        for (int i = 0; i < numTestcase; i++) {
            int numData = sc.nextInt();
            int[] dataArr = new int[MAX_SIZE];

            for (int j = 1; j <= numData; j++) {
                dataArr[j] = sc.nextInt();
            }

            numCom = 0;
            heapSort(dataArr, numData);
            System.out.println(numCom);
        }
    }

    static void heapSort(int[] dataArr, int n) {
        for (int i = n/2; i > 0; i--)
            fixHeap(dataArr, i, dataArr[i], n);

        for (int i = n; i > 1; i--) {
            int max = dataArr[1];
            fixHeap(dataArr, 1, dataArr[i], i - 1);
            dataArr[i] = max;
        }
    }

    static void fixHeap(int[] dataArr, int k, int v, int n) {
        int largerChild;
        int largerChildKey;

        while(k * 2 <= n) {
            if (k * 2 == n) {
                largerChild = dataArr[k * 2];
                largerChildKey = k * 2;
                numCom++;
            } else {
                largerChild = Math.max(dataArr[k * 2], dataArr[k * 2 + 1]);
                if (largerChild == dataArr[k * 2])
                    largerChildKey = k * 2;
                else
                    largerChildKey = k * 2 + 1;
                numCom += 2;
            }

            if (v < largerChild) {
                dataArr[k] = largerChild;
                k = largerChildKey;
            } else {
                break;
            }
        }

        dataArr[k] = v;
    }
}