package graph.p1201;

import java.util.Scanner;

/**
 * @author: Mohammed Julfikar Ali Mahbub, 18301264, CSE Dept, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
 * @Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
 * @URL: https://www.urionlinejudge.com.br/judge/en/problems/view/1201
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();
        while (sc.hasNext()) {
            String command = sc.next();
            if (command.equals("I")) {
                int n = sc.nextInt();
                bst.insert(n);
            } else if (command.equals("P")) {
                int n = sc.nextInt();
                System.out.println(n + (bst.contains(n) ? " existe" : " nao existe"));
            } else if (command.equals("R")) {
                int n = sc.nextInt();
                bst.remove(n);
            } else if (command.equals("INFIXA")) {
                System.out.println(bst.inOrder());
            } else if (command.equals("PREFIXA")) {
                System.out.println(bst.preOrder());
            } else if (command.equals("POSFIXA")) {
                System.out.println(bst.postOrder());
            } else {
                System.out.println("I got a kid in' you!!!");
            }
        }
    }
}

class BinarySearchTree {
    Node root;
    
    public void insert(int val) {
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
    
    public boolean contains(int n) {
        return contains(root, n);
    }
    
    public void remove(int n) {
        Node selectedNode = get(n);
        if (selectedNode != null) {
            Node parent = selectedNode.parent;
            if (isLeaf(selectedNode)) {
                if (isRoot(selectedNode)) {
                    root = null;
                } else if (parent.leftChild(selectedNode)) {
                    parent.left = null;
                } else if (parent.rightChild(selectedNode)) {
                    parent.right = null;
                }
            } else if (selectedNode.left == null) {
                if (isRoot(selectedNode)) {
                    root = selectedNode.right;
                } else if (parent.leftChild(selectedNode)) {
                    parent.left = selectedNode.right;
                } else {
                    parent.right = selectedNode.right;
                }
                selectedNode.right.parent = parent;
            } else if (selectedNode.right == null) {
                if (isRoot(selectedNode)) {
                    root = selectedNode.left;
                } else if (parent.leftChild(selectedNode)) {
                    parent.left = selectedNode.left;
                } else {
                    parent.right = selectedNode.left;
                }
                selectedNode.left.parent = parent;
            } else {
                Node successor = getRightMost(selectedNode.left);
                remove(successor.val);
                successor.parent = parent;
                successor.setChild(selectedNode.left, selectedNode.right);
                if (isRoot(selectedNode)) {
                    root = successor;
                } else if (parent.leftChild(selectedNode)) {
                    parent.left = successor;
                } else if (parent.rightChild(selectedNode)) {
                    parent.right = successor;
                }
            }
            selectedNode.parent = null;
            selectedNode.setChild(null, null);
        }
    }
    
    public void removeUsingSmall(int n) {
        Node selectedNode = get(n);
        if (selectedNode != null) {
            Node parent = selectedNode.parent;
            if (isLeaf(selectedNode)) {
                if (isRoot(selectedNode)) {
                    root = null;
                } else if (parent.leftChild(selectedNode)) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            } else if (selectedNode.left == null) {
                if (isRoot(selectedNode)) {
                    root = selectedNode.right;
                } else if (parent.leftChild(selectedNode)) {
                    parent.left = selectedNode.right;
                } else {
                    parent.right = selectedNode.right;
                }
                selectedNode.right.parent = parent;
            } else if (selectedNode.right == null) {
                if (isRoot(selectedNode)) {
                    root = selectedNode.left;
                } else if (parent.leftChild(selectedNode)) {
                    parent.left = selectedNode.left;
                } else {
                    parent.right = selectedNode.left;
                }
                selectedNode.left.parent = parent;
            } else {
                Node successor = getLeftMost(selectedNode.right);
                remove(successor.val);
                successor.setChild(selectedNode.left, selectedNode.right);
                if (isRoot(selectedNode)) {
                    root = successor;
                } else if (parent.leftChild(selectedNode)) {
                    parent.left = successor;
                } else {
                    parent.right = successor;
                }
            }
            selectedNode.parent = null;
            selectedNode.setChild(null, null);
        }
    }
    
    public Node get(int n) {
        return get(root, n);
    }
    
    public boolean isLeaf(Node root) {
        return root.left == null && root.right == null;
    }
    
    public boolean isRoot(Node root) {
        return root.parent == null;
    }
    
    private void insert(Node root, int val) {
        if (this.root == null) {
            this.root = new Node(val, null);
        } else if (val < root.val) {
            if (root.left == null) root.left = new Node(val, root);
            else insert(root.left, val);
        } else if (val > root.val) {
            if (root.right == null) root.right = new Node(val, root);
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
    
    private boolean contains(Node root, int n) {
        if (root == null) {
            return false;
        } else if (root.val == n) {
            return true;
        } else if (n < root.val) {
            if (root.left == null) return false;
            else return contains(root.left, n);
        } else if (n > root.val) {
            if (root.right == null) return false;
            else return contains(root.right, n);
        }
        return false;
    }
    
    private Node get(Node root, int n) {
        if (root == null) return null;
        if (root.val == n) return root;
        if (n < root.val) {
            return get(root.left, n);
        } else {
            return get(root.right, n);
        }
    }
    
    private Node getLeftMost(Node root) {
        if (root == null || root.left == null) {
            return root;
        }
        
        return getLeftMost(root.left);
    }
    
    private Node getRightMost(Node root) {
        if (root == null || root.right == null) return root;
        
        return getRightMost(root.right);
    }
}

class Node {
    int val;
    Node left, right, parent;
    
    public Node(int val, Node parent) {
        this.parent = parent;
        this.val = val;
    }
    
    public void setChild(Node left, Node right) {
        if (left != null) left.parent = this;
        if (right != null) right.parent = this;
        this.left = left;
        this.right = right;
    }
    
    public boolean leftChild(Node node) {
        return node == left;
    }
    
    public boolean rightChild(Node node) {
        return node == right;
    }
    
    public String toString() {
        return String.valueOf(val);
    }
}