package assn2;

import java.util.Arrays;
import java.util.Scanner;

public class HanoiTower {
    static String[] dataArr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTestcase = sc.nextInt();

        for (int i = 0; i < numTestcase; i++) {
            int data = sc.nextInt();
            hanoi(data, 1, 2, 3);
        }
    }

    static void hanoi(int n, int a, int b, int c) {
        if (n > 0) {
            hanoi(n - 1, a, c, b);
            if(a == 3) {
                System.out.print(n + "! ");
            } else if (b == 3) {
                System.out.print(1 + "! ");
            }else if (c == 3) {
                System.out.print("");
            }

            if(a == 3) {
                System.out.print((n + 1) + "# ");
            } else if (b == 3) {
                System.out.print("");
            }else if (c == 3) {
                System.out.print(n + "# ");
            }

            hanoi( n - 1, b, a, c);
            if(a == 3) {
                System.out.print((n + 1) + "@ ");
            } else if (b == 3) {
                System.out.print((n + 1) + "@ ");
            } else if (c == 3) {
                System.out.print(1 + "@ ");
            }
        }

    }
}