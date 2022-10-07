package assn4;

import java.util.Scanner;

public class BinarySearch {
    static final int MAX_SIZE = 1000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTestcase = sc.nextInt();

        for (int i = 0; i < numTestcase; i++) {
            int numData = sc.nextInt();
            int numData2 = sc.nextInt();
            int[] dataArray = new int[MAX_SIZE];

            for (int j = 0; j < numData; j++) {
                dataArray[j] = sc.nextInt();
            }

            System.out.println(binarySearch(dataArray, 0, numData - 1, numData2));
        }
    }

    static int binarySearch(int[] dataArray, int left, int right, int value) {
        if (left > right) {
            return -1;
        } else {
            int mid = (left + right)/2;
            if (dataArray[mid] == value) {
                return mid;
            } else if (dataArray[mid] > value) {
                return binarySearch(dataArray, left, mid - 1, value);
            } else {
                return binarySearch(dataArray, mid + 1, right, value);
            }
        }
    }
}
