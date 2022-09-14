import java.util.Scanner;

public class ShellSort {
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

            shellSort(dataArray, numData);
        }
    }
    static void shellSort(int[] dataArray, int n) {
        int countCmpOps = 0;
        int countSwaps = 0;

        // Algorithm
        int shrinkRatio = 2;
        int gap = dataArray.length / shrinkRatio;

        while ( gap > 0) {

        }

        System.out.println(countCmpOps + " " + countSwaps + " ");
    }
}