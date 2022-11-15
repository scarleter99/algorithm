package assn6;

import java.util.Objects;
import java.util.Scanner;

public class LCSmemoization {
    static final int MAX_SIZE = 10000;
    static int[][] L;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTestcase = sc.nextInt();

        for (int i = 0; i < numTestcase; i++) {
            String s1 = sc.next();
            String s2 = sc.next();
            int m = s1.length();
            int n = s2.length();

            L = new int[m + 1][n + 1];
            for (int j = 0; j < m + 1; j++)
                for ( int k = 0; k < n + 1; k++)
                    L[j][k] = -1;

            int answer = lcsMemoization(s1.split(""), s2.split(""), m, n);
            System.out.print(answer + " ");
            System.out.println();
        }
    }

    static int lcsMemoization(String[] s1, String[] s2, int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        else if (L[m][n] != -1) {
            return L[m][n];
        }

        if (Objects.equals(s1[m - 1], s2[n - 1])) {
            int answer = lcsMemoization(s1, s2, m - 1, n - 1) + 1;
            L[m][n] = answer;
            return answer;
        } else {
            int answer = Math.max(lcsMemoization(s1, s2, m - 1, n), lcsMemoization(s1, s2, m, n - 1));
            L[m][n] = answer;

            return answer;
        }

    }

}
