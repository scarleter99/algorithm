package assn2;

import java.util.Scanner;

public class HanoiTower {
    static final int MAX_SIZE = 1000;

    static int[] stack;
    static int k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numTestcase = sc.nextInt();

        for (int i = 0; i < numTestcase; i++) {
            stack = new int[MAX_SIZE];
            k = 0;

            int data = sc.nextInt();
            hanoi(data, 1, 2, 3);
            System.out.println();
        }
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
}