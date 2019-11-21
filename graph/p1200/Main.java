package graph.p1200;

import java.util.Scanner;

/**
 * @author: Mohammed Julfikar Ali Mahbub, 18301264, CSE Dept, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
 * @Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
 * @URL: https://www.urionlinejudge.com.br/judge/en/problems/view/1200
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();
        while (sc.hasNext()) {
            String command = sc.next();
            if (command.equals("I")) {
                bst.insert(sc.next().charAt(0));
            } else if (command.equals("P")) {
                char c = sc.next().charAt(0);
                System.out.println(c + (bst.contains(c) ? " existe" : " nao existe"));
            } else if (command.equals("INFIXA")) {
                System.out.println(bst.inOrder());
            } else if (command.equals("PREFIXA")) {
                System.out.println(bst.preOrder());
            } else if (command.equals("POSFIXA")) {
                System.out.println(bst.postOrder());
            } else {
                System.out.println("I gotta kidding you!!!");
            }
        }
    }
}

class BinarySearchTree {
    Node root;
    
    public void insert(char val) {
        insert(root, val);
    }
    
    public String preOrder() {
        return preOrder(root).trim();
    }
    
    public String postOrder() {
        return postOrder(root).trim();
    }
    
    public String inOrder() {
        return inOrder(root).trim();
    }
    
    public boolean contains(char c) {
        return contains(root, c);
    }
    
    private void insert(Node root, char val) {
        if (this.root == null) {
            this.root = new Node(val);
        } else if (val < root.val) {
            if (root.left == null) root.left = new Node(val);
            else insert(root.left, val);
        } else if (val > root.val) {
            if (root.right == null) root.right = new Node(val);
            else insert(root.right, val);
        }
    }
    
    private String preOrder(Node root) {
        if (root == null) return "";
        return " " + root.val + preOrder(root.left) + preOrder(root.right);
    }
    
    private String postOrder(Node root) {
        if (root == null) return "";
        return postOrder(root.left) + postOrder(root.right) + " " + root.val;
    }
    
    private String inOrder(Node root) {
        if (root == null) return "";
        return inOrder(root.left) + " " + root.val + inOrder(root.right);
    }
    
    private boolean contains(Node root, char c) {
        if (root == null) {
            return false;
        } else if (root.val == c) {
            return true;
        } else if (c < root.val) {
            if (root.left == null) return false;
            else return contains(root.left, c);
        } else if (c > root.val) {
            if (root.right == null) return false;
            else return contains(root.right, c);
        }
        return false;
    }
}

class Node {
    char val;
    Node left, right;
    
    public Node(char val) {
        this.val = val;
    }
}