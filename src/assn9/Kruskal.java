package assn9;

import java.util.Arrays;
import java.util.Scanner;

public class Kruskal {
    static final int MAX_SIZE = 1000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTestcase = sc.nextInt();

        for (int i = 0; i < numTestcase; i++) {
            int edgeNum = sc.nextInt();
            int[][] edges = new int[edgeNum][2];
            int[] weight = new int[edgeNum];

            for(int j = 0; j < edgeNum; j++) {
                edges[j][0] = sc.nextInt();
                edges[j][1] = sc.nextInt();
                weight[j] = sc.nextInt();
            }

            int[][] answer = kruskal(edges, weight, edgeNum);
            System.out.println(Arrays.deepToString(answer));
        }
    }

    public static int[][] kruskal(int[][] edge, int[] weight, int edgeNum) {
        int[][] treeEdge = new int[edgeNum][2];
        int treeEdgeNum = 0;
        int[] parent = new int[MAX_SIZE];

        for (int i = 1; i < MAX_SIZE; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < edgeNum; i++) {
            int minWeight = MAX_SIZE;
            int minWeightVNo = 0;

            for (int j = 0; j < edgeNum; j++) {
                if (weight[j] < minWeight && weight[j] > 0) {
                    minWeight = weight[j];
                    minWeightVNo = j;
                }
            }

            int minLeftV = edge[minWeightVNo][0];
            int minRightV = edge[minWeightVNo][1];

            int p = find(parent, minLeftV);
            int q = find(parent, minRightV);

            if (p != q) {
                union(parent, p, q);

                treeEdge[treeEdgeNum][0] = minLeftV;
                treeEdge[treeEdgeNum][1] = minRightV;
                treeEdgeNum++;
            }

            weight[minWeightVNo] = -1;
        }

        return treeEdge;
    }

    public static int find(int[] parent, int i) {
        while(parent[i] != i)
            i = parent[i];

        return i;
    }

    public static void union(int[] parent, int p, int q) {
        if (p <= q)
            parent[q] = p;
        else
            parent[p] = q;
    }
}
