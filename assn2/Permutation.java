package assn2;

import java.util.Scanner;

public class Permutation {
    static String[] dataArr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTestcase = sc.nextInt();

        for (int i = 0; i < numTestcase; i++) {
            String data = sc.next();
            dataArr = data.split("");
            rev(dataArr, 0, dataArr.length - 1);
        }
    }

    static void rev(String[] dataArr, int left, int right) {

    }
}