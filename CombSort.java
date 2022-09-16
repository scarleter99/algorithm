import java.util.Scanner;

public class CombSort {
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

            combSort(dataArray, numData);
        }
    }

    static void combSort(int[] dataArray, int n) {
        int countCmpOps = 0;
        int countSwaps = 0;

        // Algorithm
        int gap = n;
        double shrink = 1.3;
        boolean sorted = false;

        while (sorted == false) {
            gap = (int) (gap/shrink);
            if (gap <= 1) {
                gap = 1;
                sorted = true;
            }

            int i = 0;
            while (i + gap < n) {
                if (dataArray[i] > dataArray[i + gap]) {
                    int tmp = dataArray[i];
                    dataArray[i] = dataArray[i + gap];
                    dataArray[i+ gap] = tmp;
                    sorted = false;
                    countSwaps++;
                }
                i++;
                countCmpOps++;
            }
        }

        System.out.println(countCmpOps + " " + countSwaps + " ");
        //System.out.println(Arrays.toString(dataArray));
    }
}