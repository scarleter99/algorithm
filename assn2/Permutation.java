package assn2;

import java.util.Arrays;
import java.util.Scanner;

public class Permutation {
    static String[] dataArr;
    static int[] asciiArr;
    static int sumPostive = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTestcase = sc.nextInt();

        for (int i = 0; i < numTestcase; i++) {
            sumPostive = 0;
            String data = sc.next();
            dataArr = data.split("");
            rev(0, dataArr.length);
            System.out.println(sumPostive);
        }
    }

    static void rev(int begin, int end) {
        int range = end - begin;

        if(range == 1) {
            //System.out.println(Arrays.toString(dataArr));
            ascii();
        } else {
            for (int i = 0; i < range; i++) {
                String tmp1 = dataArr[begin];
                dataArr[begin] = dataArr[begin + i];
                dataArr[begin + i] = tmp1;
                rev(begin + 1, end);
                String tmp2 = dataArr[begin];
                dataArr[begin] = dataArr[begin + i];
                dataArr[begin + i] = tmp2;
            }
        }
    }

    static void ascii() {
       asciiArr = new int[dataArr.length];
        for (int i = 0; i < dataArr.length; i++) {
            asciiArr[i] = (dataArr[i].charAt(0) - 'a') * (int)Math.pow(-1, i);
        }
        //System.out.println(Arrays.toString(asciiArr));
        if (Arrays.stream(asciiArr).sum() > 0) {
            sumPostive++;
        }
    }
}