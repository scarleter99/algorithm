package assn6;

import java.util.Objects;
import java.util.Scanner;

public class LCSdp {
    static final int MAX_SIZE = 10000;
    static int[][] L;
    static int[][] S;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTestcase = sc.nextInt();

        for (int i = 0; i < numTestcase; i++) {
            String s1 = sc.next();
            String s2 = sc.next();
            int m = s1.length();
            int n = s2.length();

            L = new int[m + 1][n + 1];
            S = new int[m + 1][n + 1];

            int answer = lcsDP(s1.split(""), s2.split(""), m, n);
            System.out.print(answer + " ");
            printLCS(s1.split(""), s2.split(""), m, n);
            System.out.println();
        }
    }

    static int lcsDP(String[] s1, String[] s2, int m, int n) {

        for (int i = 0; i <= m; i++)
            L[i][0] = 0;
        for (int i = 0; i <= n; i++)
            L[0][i] = 0;

        for(int i = 1; i <= m; i++)
            for(int j = 1; j <= n; j++)
                if (Objects.equals(s1[i - 1], s2[j - 1])){
                    L[i][j] = L[i-1][j-1]+1;
                    S[i][j] = 0;
                }
                else{
                    L[i][j] = Math.max(L[i][j - 1], L[i - 1][j]);
                    if (L[i][j] == L[i][j - 1])
                        S[i][j] = 1;
                    else
                        S[i][j] = 2;
                }

        return L[m][n];
    }

    static void printLCS(String[] s1, String[] s2, int m, int n)
    {
        if(m==0 || n==0)
            return;

        if(S[m][n] == 0)
        {
            printLCS(s1, s2, m-1, n-1);
            System.out.print(s1[m-1]);
        }
        else if(S[m][n] == 1)
            printLCS(s1, s2, m, n-1);
        else if(S[m][n] == 2)
            printLCS(s1, s2, m-1, n);
    }
}
