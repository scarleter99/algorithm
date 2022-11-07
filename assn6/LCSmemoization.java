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

            int answer = lcsMemoization(s1.split(""), s2.split(""), m, n);
            System.out.println(answer);
        }
    }

    static int lcsMemoization(String[] s1, String[] s2, int m, int n) {

        for (int i = 0; i <= m; i++)
            L[i][0] = 0;
        for (int i = 0; i <= n; i++)
            L[0][i] = 0;

        for(int i = 1; i <= m; i++)
            for(int j = 1; j <= n; j++)
                if (Objects.equals(s1[i - 1], s2[j - 1])){
                    L[i][j] = L[i-1][j-1]+1;
                }
                else{
                    L[i][j] = Math.max(L[i][j - 1], L[i - 1][j]);
                }

        return L[m][n];
    }

}