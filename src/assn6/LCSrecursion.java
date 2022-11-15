package assn6;

import java.util.Objects;
import java.util.Scanner;

public class LCSrecursion {
    static final int MAX_SIZE = 10000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTestcase = sc.nextInt();

        for (int i = 0; i < numTestcase; i++) {
            String s1 = sc.next();
            String s2 = sc.next();
            int m = s1.length();
            int n = s2.length();

            int answer = lcsRecursion(s1.split(""), s2.split(""), m, n);
            System.out.println(answer);
        }
    }

    static int lcsRecursion(String[] s1, String[] s2, int m, int n) {
        if (m == 0 || n == 0)
            return 0;

        if (Objects.equals(s1[m - 1], s2[n - 1])) {
            int answer = lcsRecursion(s1, s2, m - 1, n - 1) + 1;
            return answer;
        } else {
            int answer = Math.max(lcsRecursion(s1, s2, m - 1, n), lcsRecursion(s1, s2, m, n - 1));
            return answer;
        }

    }

}