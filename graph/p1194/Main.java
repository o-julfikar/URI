package graph.p1194;

import java.util.Scanner;

/**
 * @author: Mohammed Julfikar Ali Mahbub, 18301264, CSE Dept, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
 * @Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
 * @URL: https://www.urionlinejudge.com.br/judge/en/problems/view/1194
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        while (c --> 0) {
            sc.nextInt();
            System.out.println(new Graph(sc.next(), sc.next()).postOrder());
        }
    }
}

class Graph {
    
    public int[] in = new int[58];
    Node root;
    
    public Graph(String pre, String in) {
        for (int i = 0; i < pre.length(); i++) {
            this.in[in.charAt(i) - 'A'] = i;
        }
        root = build(pre);
    }
    
    public Node build(String pre) {
        if (pre.length() == 0) return null;
        Node node = new Node(pre.charAt(0));
        if (pre.length() == 1) return node;
        StringBuilder preLeft = new StringBuilder(), preRight = new StringBuilder();
        for (int i = 1; i < pre.length(); i++) {
            if (in[pre.charAt(i) - 'A'] < in[pre.charAt(0) - 'A']) {
                preLeft.append(pre.charAt(i));
            } else {
                preRight.append(pre.charAt(i));
            }
        }
        node.left = build(preLeft.toString());
        node.right = build(preRight.toString());
        
        return node;
    }
    
    public String postOrder() {
        return postOrder(root);
    }
    
    public String postOrder(Node root) {
        if (root == null) return "";
        return postOrder(root.left) + postOrder(root.right) + root.id;
    }
}

class Node {
    char id;
    Node left, right;
    
    public Node(char id) {
        this.id = id;
    }
}
