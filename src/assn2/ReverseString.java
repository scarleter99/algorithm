package assn2;

import java.util.Scanner;

public class ReverseString {
    static String[] dataArr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTestcase = sc.nextInt();

        for (int i = 0; i < numTestcase; i++) {
            String data = sc.next();
            dataArr = data.split("");
            rev(dataArr, 0, dataArr.length - 1);
            System.out.println(String.join("", dataArr));
        }
    }

    static void rev(String[] dataArr, int begin, int end) {
        if (begin < end) {
            String tmp = dataArr[begin];
            dataArr[begin] = dataArr[end];
            dataArr[end] = tmp;
            rev(dataArr, begin+1, end - 1);
        }
    }
}