package assn8;

import java.util.Scanner;

public class KMPFail {
    static final int MAX_SIZE = 10000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTestcase = sc.nextInt();

        for (int i = 0; i < numTestcase; i++) {
            String pattern = sc.next();
            String text = sc.next();

            int[] fail = getFail(pattern);
            int matchNum = kmpFail(text, pattern, fail);

            for (int j: fail)
                System.out.print(j + " ");

            System.out.println( "\n" + matchNum);
        }
    }

    static int kmpFail(String text, String pattern, int[] fail) {
        int n = text.length();
        int m = pattern.length();
        int matchNum = 0;
        int j = 0;

        for (int i = 0; i < n; i++) {
            while (j > 0 && text.charAt(i) != pattern.charAt(j))
                j = fail[j - 1];

            if (text.charAt(i) == pattern.charAt(j)) {
                if (j == m - 1) {
                    matchNum++;
                    j = fail[j];
                } else
                    j++;
            }
        }

        return matchNum;
    }


    static int[] getFail(String pattern) {
        int m = pattern.length();
        int j = 0;
        int[] fail = new int[m];

        for (int i = 1; i < m; i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j))
                j = fail[j - 1];

            if (pattern.charAt(i) == pattern.charAt(j))
                fail[i] = ++j;
        }

        return fail;
    }
}
