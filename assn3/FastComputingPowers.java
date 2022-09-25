package assn3;

import java.util.Scanner;

public class FastComputingPowers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTestcase = sc.nextInt();

        for (int i = 0; i < numTestcase; i++) {
            int data1 = sc.nextInt();
            int data2 = sc.nextInt();
            System.out.println(fcp(data1, data2));
        }
    }

    static int fcp(int x, int n) {
        if (n == 0) {
            return 1;
        } else if (n % 2 == 0) {
            return (int) Math.pow(fcp(x, n / 2), 2) % 1000;
        } else {
            return x * (int) Math.pow(fcp(x, (n - 1) / 2), 2) %  1000;
        }
    }

}
