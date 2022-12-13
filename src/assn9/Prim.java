package assn9;

import java.util.Arrays;
import java.util.Scanner;

public class Prim {
    static final int MAX_SIZE = 1000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTestcase = sc.nextInt();

        for (int i = 0; i < numTestcase; i++) {
            int vNum = sc.nextInt();
            int[][] edges = new int[vNum + 1][vNum + 1];

            for(int j = 1; j < vNum + 1; j++) {
                for (int k = 1; k < vNum + 1; k++) {
                    edges[j][k] = sc.nextInt();

                    if (edges[j][k] == -1)
                        edges[j][k] = MAX_SIZE;
                }
            }

            int[][] answer = prim(edges, vNum);
            System.out.println(Arrays.deepToString(answer));
        }
    }

    public static int[][] prim(int[][] edges, int vNum) {
        int[][] treeEdge = new int[vNum - 1][2];
        int treeEdgeNum = 0;
        int[] nearest = new int[MAX_SIZE];
        int[] distance = new int[MAX_SIZE];

        for (int i = 2; i < vNum + 1; i++) {
            nearest[i] = 1;
            distance[i] = edges[1][i];
        }

        for (int i = 0; i < vNum - 1; i++) {
            int min = MAX_SIZE;
            int minV = 0;

            for (int j = 2; j < vNum + 1; j++) {
                if (distance[j] < min && distance[j] > 0) {
                    min = distance[j];
                    minV = j;
                }
            }

            treeEdge[treeEdgeNum][0] = nearest[minV];
            treeEdge[treeEdgeNum][1] = minV;
            treeEdgeNum++;
            distance[minV] = -1;

            for (int j = 0; j < vNum + 1; j++) {
                if (distance[j] > edges[minV][j] && edges[minV][j] > 0) {
                    distance[j] = edges[minV][j];
                    nearest[j] = minV;
                }
            }
        }

        return treeEdge;
    }
}
