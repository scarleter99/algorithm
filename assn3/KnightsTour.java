package assn3;

import java.util.Scanner;

public class KnightsTour {

    static boolean[][] board;
    static int[][] path;
    static int[][] direction = {{1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTestcase = sc.nextInt();

        for (int i = 0; i < numTestcase; i++) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            Point point = new Point(x, y);

            board = new boolean[100][100];
            path = new int[100][100];
            board[x][y] = true;
            path[x][y] = 1;
            int result = knightsTour(m, n, point, 1);
            System.out.println(result);

            if (result == 1) {
                for (int j = 1; j <= m; j++) {
                    for (int k = 1; k <= n; k++) {
                        System.out.print(path[j][k] + " ");
                    }
                    System.out.println();
                }
            }
        }
    }

    static int knightsTour(int m, int n, Point point, int counter) {
        Point next = new Point();

        if (counter == m * n) {
            return 1;
        }

        for (int i = 0; i < 8; i++) {
            next.x = point.x + direction[i][0];
            next.y = point.y + direction[i][1];

            if(next.x > 0 && next.x <= m && next.y > 0 && next.y <= n &&
                    !board[next.x][next.y]) {
                board[next.x][next.y] = true;
                path[next.x][next.y] = counter + 1;

                if ( knightsTour(m, n, next, counter + 1) == 1)
                    return 1;
                board[next.x][next.y] = false;
            }
        }
        return 0;
    }

}

class Point {
    int x;
    int y;

    Point() {
        this.x = -1;
        this. y = -1;
    }

    Point(int x, int y) {
        this.x = x;
        this. y = y;
    }
}
