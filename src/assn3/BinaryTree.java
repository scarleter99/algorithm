package assn3;

import java.util.Scanner;

public class BinaryTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTestcase = sc.nextInt();
        for (int i = 0; i < numTestcase; i++) {
            Node root = new Node();

            int numData = sc.nextInt();
            for (int j = 0; j < numData; j++) {
                int data = sc.nextInt();
                root.insert(data);
            }
            System.out.println(root.size());
            System.out.println(root.height());
            System.out.println(root.sumOfWeight());
            System.out.println(root.maxPathWeight());
            root.mirror();
            root.preOrder();
            System.out.println();
            root.inOrder();
            System.out.println();
            root.postOrder();
            System.out.println();
            root = null;
            if (root == null) {
                System.out.println("0");
            } else {
                System.out.println("1");
            }

        }
    }
}

class Node {
    int data = -1;
    Node left;
    Node right;

    public void insert(int data) {
        if (this.data < 0) {
            this.data = data;
            this.left = new Node();
            this.right = new Node();
        }
        else if (data < this.data) {
            this.left.insert(data);
        } else {
            this.right.insert(data);
        }
    }

    public void preOrder() {
        if (this.data < 0) {
            return;
        }
        System.out.print(data + " ");
        this.left.preOrder();
        this.right.preOrder();
    }

    public void inOrder() {
        if (this.data < 0) {
            return;
        }
        this.left.inOrder();
        System.out.print(data + " ");
        this.right.inOrder();
    }

    public void postOrder() {
        if (this.data < 0) {
            return;
        }
        this.left.postOrder();
        this.right.postOrder();
        System.out.print(this.data + " ");
    }

    public int size() {
        if (this.data < 0) {
            return 0;
        }
        return this.left.size() + this.right.size() + 1;
    }

    public int height() {
        if (this.data < 0) {
            return -1;
        }
        return Math.max(this.left.height(), this.right.height()) + 1;
    }

    public int sumOfWeight() {
        if (this.data < 0) {
            return 0;
        }
        return this.left.sumOfWeight() + this.right.sumOfWeight() + this.data;
    }

    public int maxPathWeight() {
        if (this.data < 0) {
            return 0;
        }
        return Math.max(this.left.maxPathWeight(), this.right.maxPathWeight()) + this.data;
    }

    public void mirror() {
        Node tmp = this.left;
        this.left = this.right;
        this.right = tmp;

        if (this.left != null) {
            this.left.mirror();
        }
        if (this.right != null) {
            this.right.mirror();
        }
    }
}