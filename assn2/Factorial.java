package assn2;

import java.util.Scanner;

public class Factorial {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTestcase = sc.nextInt();

        for (int i = 0; i < numTestcase; i++) {
            int data = sc.nextInt();
            System.out.println(fac(data));
        }
    }

    static int fac(int n) {
        if (n <= 1){
            return 1;
        } else {
            n *= fac(n-1);
            while (n % 10 == 0) {
                n /= 10;
            }
            return (n % 1000);
        }
    }
}