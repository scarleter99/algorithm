package assn9;

import java.util.Arrays;
import java.util.Scanner;

public class DFS {
    static final int MAX_SIZE = 1000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTestcase = sc.nextInt();

        for (int i = 0; i < numTestcase; i++) {
            int vNum = sc.nextInt();
            int edgeNum = sc.nextInt();
            Node[] vList = new Node[vNum + 1];
            int[] mark = new int[vNum + 1];

            for(int j = 0; j < edgeNum; j++) {
                int v1 = sc.nextInt();
                int v2 = sc.nextInt();
                if(vList[v1] == null)
                    vList[v1] = new Node(v2);
                else
                    vList[v1].link(new Node(v2));
            }

            graph(vList, mark, vNum);
        }
    }

    public static void graph(Node[] vList, int[] mark, int vNum) {
        for (int i = 1; i < vNum + 1; i++) {
            if (mark[i] == 0) {
                mark[i] = 1;
                System.out.println(i + ",, ");
                dfs(vList, mark, vNum, vList[i]);
            }
        }
    }

    public static void dfs(Node[] vList, int[] mark, int vNum, Node v) {
        Node pointer = v;

        while (pointer != null) {
            if (mark[pointer.vertex] == 0) {
                mark[pointer.vertex] = 1;
                System.out.println(pointer.vertex + ", ");

                dfs(vList, mark, vNum, vList[pointer.vertex]);
            }

            pointer = pointer.child;
        }

    }

}

class Node {
    int vertex;
    Node child = null;

    Node(int _vertex) {
        vertex = _vertex;
    }

    void link(Node _node) {
        if (child == null)
            child = _node;
        else
            child.link(_node);
    }

}
