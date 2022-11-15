package assn7;

import java.util.Scanner;

public class HeapSort {
    static final int MAX_SIZE = 100000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTestcase = sc.nextInt();

        for (int i = 0; i < numTestcase; i++) {
            int numData = sc.nextInt();
            int[] numArr = new int[numData];

            Node root = new Node();
            for (int j = 0; j < numData; j++) {
                int k = sc.nextInt();

                fixHeap(root, k);
            }
        }
    }

    static void heapSort (int[] numArr, int n) {

    }

    static void fixHeap(Node root, int k) {
        Node vacant = root;

        while (!(vacant.left == null && vacant.right == null)) {
            Node largerChild;

            if (vacant.right == null || (vacant.left != null && vacant.right.data > vacant.left.data))
                largerChild = vacant.right;
            else
                largerChild = vacant.left;

            if (k < largerChild.data) {
                vacant.data = largerChild.data;
                vacant = largerChild;
            } else {
                break;
            }
        }

        vacant.data = k;
    }
}

class Node {
    int data;
    Node left;
    Node right;

    Node() { }

    Node(int _data) {
        data = _data;
    }
}
