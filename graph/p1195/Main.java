package graph.p1195;

import java.util.Scanner;

/**
 * @author: Mohammed Julfikar Ali Mahbub, 18301264, CSE Dept, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
 * @Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
 * @URL: https://www.urionlinejudge.com.br/judge/en/problems/view/1195
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();

        for (int s = 1; s <= c; s++) {
            System.out.printf("Case %d:\n", s);
            int n = sc.nextInt();
            int[] data = new int[n];
            for (int i = 0; i < n; i++) {
                data[i] = sc.nextInt();
            }

            BinarySearchTree bst = new BinarySearchTree(data);
            System.out.println("Pre.:" + bst.traverse(BinarySearchTree.PRE));
            System.out.println("In..:" + bst.traverse(BinarySearchTree.IN));
            System.out.println("Post:" + bst.traverse(BinarySearchTree.POST));
            System.out.println();
        }
    }
}

class BinarySearchTree {

    public static final int PRE = 0, POST = 1, IN = 2;
    public Node root;

    public BinarySearchTree(int[] data) {
        root = new Node(data[0]);
        for (int i = 1; i < data.length; i++) {
            insert(root, data[i]);
        }
    }

    public void insert(Node root, int value) {
        if (value > root.value) {
            if (root.right == null) {
                root.right = new Node(value);
            } else {
                insert(root.right, value);
            }
        } else {
            if (root.left == null) {
                root.left = new Node(value);
            } else {
                insert(root.left, value);
            }
        }
    }

    public String traverse(int method) {
        if (method == PRE) {
            return preOrder(root);
        }
        if (method == POST) {
            return postOrder(root);
        }
        if (method == IN) {
            return inOrder(root);
        }
        return "";
    }

    public String preOrder(Node root) {
        if (root == null) {
            return "";
        }

        return " " + root.value + preOrder(root.left) + preOrder(root.right);
    }

    public String postOrder(Node root) {
        if (root == null) {
            return "";
        }

        return postOrder(root.left) + postOrder(root.right) + " " + root.value;
    }

    public String inOrder(Node root) {
        if (root == null) {
            return "";
        }

        return inOrder(root.left) + " " + root.value + inOrder(root.right);
    }
}

class Node {

    int value;
    Node left, right;

    public Node(int value) {
        this.value = value;
    }
}
