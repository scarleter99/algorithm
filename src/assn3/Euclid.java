package assn3;

import java.util.Scanner;

public class Euclid {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTestcase = sc.nextInt();

        for (int i = 0; i < numTestcase; i++) {
            int data1 = sc.nextInt();
            int data2 = sc.nextInt();
            System.out.println(euclid(data1, data2));
        }
    }

    static int euclid(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        } else {
            return euclid(n2, n1 % n2);
        }
    }
}