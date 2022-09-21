package assn2;

import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTestcase = sc.nextInt();

        for (int i = 0; i < numTestcase; i++) {
            int data = sc.nextInt();
            System.out.println(fibo(data));
        }
    }

    static int fibo(int n) {
        if (n <= 1 ) {
            return n;
        } else{
            return fibo(n - 1) + fibo(n - 2);
        }
    }
}
