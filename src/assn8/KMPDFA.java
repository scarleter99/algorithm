package assn8;

import java.util.Scanner;

public class KMPDFA {
    static final int MAX_SIZE = 1000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTestcase = sc.nextInt();

        for (int i = 0; i < numTestcase; i++) {
            String pattern = sc.next();
            String text = sc.next();

            int[][] dfa = getDFA(pattern);
            int matchNum = kmpDFA(text, pattern, dfa);
            int noneZeroEdge = 0;

            for (int[] j : dfa){
                for (int k : j) {
                    //System.out.print(k);

                    if (k != 0)
                        noneZeroEdge++;
                }
                //System.out.println();
            }

            System.out.println(noneZeroEdge + " " + matchNum);
        }
    }

    static int kmpDFA(String text, String pattern, int[][] dfa) {
        int n = text.length();
        int m = pattern.length();
        int matchNum = 0;
        int j = 0;

        for(int i = 0; i < n; i++) {
            j = dfa[alphaToInt(text.charAt(i))][j];

            if (j == m)
                matchNum++;
        }

        return matchNum;
    }


    static int[][] getDFA(String pattern) {
        int m = pattern.length();
        int[][] dfa = new int[3][m + 1];
        dfa[alphaToInt(pattern.charAt(0))][0] = 1;

        for(int x = 0, j = 1; j <= m; j++) {
            for (int c = 0; c < 3; c++)
                dfa[c][j] = dfa[c][x];

            if (j != m) {
                dfa[alphaToInt(pattern.charAt(j))][j] = j + 1;
                x = dfa[alphaToInt(pattern.charAt(j))][x];
            }
        }

        return dfa;
    }

    static int alphaToInt(char alpha) {
        if(alpha == 'A')
            return 0;
        else if (alpha == 'B')
            return 1;
        else
            return 2;
    }
}
