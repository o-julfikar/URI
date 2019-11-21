package beginner.p2698;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author: Mohammed Julfikar Ali Mahbub, 18301264, CSE Dept, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
 * @Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
 * @URL: https://www.urionlinejudge.com.br/judge/en/problems/view/2698
 */
public class Main {

    public static void main(String[] args) throws IOException {
        int l, c, n, p, x;
        long a, b, s, m1, m2;
        Scanner sc = new Scanner(System.in);
//        sc = new Scanner(new java.io.File(System.getProperty("user.dir") + "/src/beginner/p2698/input.txt"));

        l = sc.nextInt();
        c = sc.nextInt();
        n = sc.nextInt();

        SegmentTree tree = new SegmentTree(l);

        for (int i = 0; i < n; i++) {
            p = sc.nextInt();
            x = sc.nextInt();
            a = sc.nextLong();
            b = sc.nextLong();

            s = tree.count(p);

            m1 = (a % l + ((s % l) * (s % l)) % l) % l;
            m2 = (a % l + ((s % l + b % l) * (s % l + b % l) % l)) % l;

            tree.update((int) Math.min(m1, m2), (int) Math.max(m1, m2), x);
        }
        int max = 0;
        for (int i = 1; i <= c; i++) {
            max = Math.max(max, tree.count(i));
        }
        System.out.println(max);
    }
}

class SegmentTree {

    Node root;
    public int level, length;

    public SegmentTree(int n) {
        length = n - 1;
        Queue<Node> queue = new LinkedList<Node>();
        while (n-- > 0) {
            queue.offer(new Node(1, 1, 1, 0, level));
        }

        while (queue.size() > 1) {
            level++;
            queue = build(queue);
        }
        root = queue.peek();
    }

    public Queue<Node> build(Queue<Node> source) {
        Queue<Node> queue = new LinkedList<Node>();
        while (!source.isEmpty()) {
            Node child = new Node(source.poll(), source.poll(), level);
            if (child.left != null) {
                child.leftQuantity = child.left.leftQuantity + child.left.rightQuantity;
            }
            if (child.right != null) {
                child.rightQuantity = child.right.leftQuantity + child.right.rightQuantity;
            }
            queue.offer(child);
        }
        return queue;
    }

    public int count(int color) {
        return count(root, color);
    }

    public int count(Node root, int color) {
        if (root == null) {
            return 0;
        }

        int cnt = 0;
        if (root.leftQuantity > 0) {
            if (root.leftColor == color) {
                cnt += root.leftQuantity;
            }
        } else {
            cnt += count(root.left, color);
        }
        if (root.rightQuantity > 0) {
            if (root.rightColor == color) {
                cnt += root.rightQuantity;
            }
        } else {
            cnt += count(root.right, color);
        }

        return cnt;
    }

    public void update(int start, int end, int color) {
        update(0, length, start, end, color, root);
    }

    public void update(int left, int right, int start, int end, int color, Node root) {
        if (root == null) {
            return;
        }
        int range = (int) Math.pow(2, root.level - 1);
        if (start == left && end == right) {
            // complete overlap
            root.leftColor = root.rightColor = color;
            root.leftQuantity = Math.abs(root.leftQuantity);
            root.rightQuantity = Math.abs(root.rightQuantity);
            return;
        }

        if (start < left + range) {
            if (!(root.leftColor == color && root.leftQuantity > 0)) {
                if (root.leftQuantity > 0 && root.left != null) {
                    root.left.leftColor = root.left.rightColor = root.leftColor;
                    root.left.leftQuantity = Math.abs(root.left.leftQuantity);
                    root.left.rightQuantity = Math.abs(root.left.rightQuantity);
                }
                update(left, left + range - 1, start, Math.min(end, left + range - 1), color, root.left);
                if (root.left != null) {
                    if (root.left.leftColor == root.left.rightColor && root.left.leftQuantity >= 0 && root.left.rightQuantity >= 0) {
                        root.leftColor = root.left.leftColor;
                        root.leftQuantity = Math.abs(root.leftQuantity);
                    } else {
                        root.leftQuantity = -Math.abs(root.leftQuantity);
                    }
                }
            }
        }

        if (end >= left + range) {
            if (!(root.rightColor == color && root.rightQuantity > 0)) {
                if (root.rightQuantity > 0 && root.right != null) {
                    root.right.leftColor = root.right.rightColor = root.rightColor;
                    root.right.leftQuantity = Math.abs(root.right.leftQuantity);
                    root.right.rightQuantity = Math.abs(root.right.rightQuantity);
                }
                update(left + range, right, Math.max(left + range, start), end, color, root.right);
                if (root.right != null) {
                    if (root.right.leftColor == root.right.rightColor && root.right.leftQuantity >= 0 && root.right.rightQuantity >= 0) {
                        root.rightColor = root.right.leftColor;
                        root.rightQuantity = Math.abs(root.rightQuantity);
                    } else {
                        root.rightQuantity = -Math.abs(root.rightQuantity);
                    }
                }
            }
        }
    }
}

class Node {

    public static int totalNodes;
    int id, level, leftColor = 1, leftQuantity = 1, rightColor = 1, rightQuantity = 0;
    Node left, right;

    public Node(int lc, int lq, int rc, int rq, int level) {
        this.id = totalNodes++;
        leftColor = lc;
        leftQuantity = lq;
        rightColor = rc;
        rightQuantity = rq;
        this.level = level;
    }

    public Node(Node left, Node right, int level) {
        this.id = totalNodes++;
        this.left = left;
        this.right = right;
        this.level = level;
    }

    public String toString() {
        return String.format("%d: {%d, %d, %d, %d} :%d", id, leftColor, leftQuantity, rightColor, rightQuantity, level);
    }
}
