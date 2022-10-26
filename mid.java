import java.util.Scanner;

public class mid {

    static final int MAX_SIZE = 1000;
    static int[] stack;
    static int k;
    static String[] dataArr;
    static int[] dataArray;
    static int num;
    static int swapHoareNum, swapLomutoNum, cmpHoareNum, cmpLomutoNum;

    static void bubbleSort(int[] dataArray, int n) {
        int countCmpOps = 0;
        int countSwaps = 0;

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
        }
    }

    static void combSort(int[] dataArray, int n) {
        int countCmpOps = 0;
        int countSwaps = 0;

        int gap = n;
        double shrink = 1.3;
        boolean sorted = false;

        while (!sorted) {
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
    }

    static void insertionSort(int[] dataArray, int n) {
        int countCmpOps = 0;
        int countSwaps = 0;

        for (int i = 1; i < n; i++) {
            countCmpOps++;
            for (int j = i; j > 0 && dataArray[j-1] > dataArray[j]; j--) {
                int tmp = dataArray[j];
                dataArray[j] = dataArray[j-1];
                dataArray[j-1] = tmp;
                countSwaps++;
                if ((j - 1) > 0) {
                    countCmpOps++;
                }
            }
        }

        System.out.println(countCmpOps + " " + countSwaps + " ");
    }

    static void selectionSort(int[] dataArray, int n) {
        int countCmpOps = 0;
        int countSwaps = 0;

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

    static void shellSort(int[] dataArray, int n) {
        int countCmpOps = 0;
        int countSwaps = 0;

        int shrinkRatio = 2;
        int gap = n / shrinkRatio;

        while ( gap > 0) {
            for (int i = gap; i < n; i++) {
                int tmp = dataArray[i];
                int j;
                countCmpOps++;
                for (j = i; (j >= gap) && (dataArray[j - gap] > tmp); j -= gap) {
                    dataArray[j] = dataArray[j - gap];
                    countSwaps++;
                    if ((j - gap) >= gap) {
                        countCmpOps++;
                    }
                }
                dataArray[j] = tmp;
            }
            gap /= shrinkRatio;
        }

        System.out.println(countCmpOps + " " + countSwaps + " ");
    }

    static void hanoi(int n, int a, int b, int c) {
        if (n > 0) {
            hanoi(n - 1, a, c, b);
            if (c == 3) {
                System.out.print(n + " ");
                stack[++k] = n;
            }
            if (a == 3) {
                System.out.print(stack[--k] + " ");
            }
            hanoi( n - 1, b, a, c);
        }
    }

    static void permutation(int begin, int end) {
        int range = end - begin;

        if(range == 1) {
            //ascii();
        } else {
            for (int i = 0; i < range; i++) {
                String tmp1 = dataArr[begin];
                dataArr[begin] = dataArr[begin + i];
                dataArr[begin + i] = tmp1;
                permutation(begin + 1, end);
                String tmp2 = dataArr[begin];
                dataArr[begin] = dataArr[begin + i];
                dataArr[begin + i] = tmp2;
            }
        }
    }

    static int[][] ffibo(int n, int k, int[][] matrix, int[][] tmp) {
        if (Math.pow(2, k) > n){
            return matrix;
        }
        if ((n & (1 << k)) != 0) {
            matrix = mult(matrix, tmp);
        }

        return ffibo(n, ++k, matrix, mult(tmp, tmp));
    }

    static int[][] mult(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for (int i = 0; i < arr1.length; ++i) {
            for (int j = 0; j < arr2[0].length; ++j) {
                for (int k = 0; k < arr1[0].length; ++k) {
                    answer[i][j] += (arr1[i][k] * arr2[k][j]);
                    answer[i][j] = answer[i][j] % 1000;
                }
            }
        }

        return answer;
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

    static int mcss(int[] dataArray, int low, int high) {
        if (low == high)
            return dataArray[low];

        int mid = (low + high) / 2;
        int left = mcss(dataArray, low, mid);
        int right = mcss(dataArray, mid + 1, high);
        int center = centerSum(dataArray, low, mid, high);

        return Math.max(Math.max(left,right),center);
    }

    static int centerSum(int[] dataArray, int low, int mid, int high) {
        int left = 0, right = 0;
        int leftMax = dataArray[mid], rightMax = dataArray[mid + 1];

        for (int i = mid; i >= low; i--) {
            left += dataArray[i];
            leftMax = Math.max(leftMax, left);
        }

        for (int i = mid + 1; i <= high; i++) {
            right += dataArray[i];
            rightMax = Math.max(rightMax, right);
        }

        return leftMax + rightMax;
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

    static void mergeSortIterative(int n) {
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
                merge(low, mid, high);
            }
            size *= 2;
        }
    }

    static void merge(int low, int mid, int high) {
        int[] tmp = new int[MAX_SIZE];

        for(int i = low; i <= high; i++)
            tmp[i] = dataArray[i];

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
