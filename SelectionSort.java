import java.util.Scanner;

public class SelectionSort {
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

            selectionSort(dataArray, numData);
        }
    }
    static void selectionSort(int[] dataArray, int n) {
        int countCmpOps = 0;
        int countSwaps = 0;

        // Algorithm
        for (int i = 0; i < n-1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (dataArray[j] < dataArray[minIdx]){
                    minIdx = j;
                }

                countCmpOps++;
            }

            if (minIdx != i) {
                int dev = dataArray[i];
                dataArray[i] = dataArray[minIdx];
                dataArray[minIdx] = dev;

                countSwaps++;
            }
        }

        System.out.println(countCmpOps + " " + countSwaps + " ");
    }
}
