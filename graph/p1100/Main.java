package graph.p1100;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author: Mohammed Julfikar Ali Mahbub, 18301264, CSE Dept, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
 * @Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
 * @URL: https://www.urionlinejudge.com.br/judge/en/problems/view/1100
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext("[a-h][1-8]")) {
            String start = sc.next(), end = sc.next();
            int i = start.charAt(0) - 'a', j = start.charAt(1) - '1', k = end.charAt(0) - 'a', l = end.charAt(1) - '1';
            Graph chess = new Graph();
            chess.getMoves(i, j, k, l);
        }
    }
}

class Graph {

    Vertex[] list = new Vertex[64];
    int[][] matrix = new int[8][8];

    public Graph() {
        for (int i = 0; i < list.length; i++) {
            list[i] = new Vertex(i, i + 1);
        }
    }

    public void getMoves(int i, int j, int k, int l) {
        Vertex src = getVertex(i, j), dest = getVertex(k, l);
        src.key = 0;
        PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>();
        for (Vertex v : list) {
            queue.offer(v);
        }
        int visited = 0;

        while (visited < list.length && !queue.isEmpty()) {
            Vertex u = queue.poll();
            u.visit();
            visited++;
            Vertex[] adj = {getTopLeft(u), getTopRight(u), getUpLeft(u), getUpRight(u), getDownLeft(u), getDownRight(u), getBottomLeft(u), getBottomRight(u)};
            for (Vertex v : adj) {
                if (v != null && !v.visited && v.key > u.key + 1) {
                    v.key = u.key + 1;
                    queue.remove(v);
                    queue.offer(v);
                }
            }
        }
        System.out.printf("To get from %c%d to %c%d takes %d knight moves.\n", i + 'a', j + 1, k + 'a', l + 1, dest.key);

        for (Vertex v : list) {
            v.reset();
        }
    }

    public Vertex getTopLeft(Vertex src) {
        int i = src.index / 8 + 2, j = src.index % 8 - 1;
        return getVertex(i, j);
    }

    public Vertex getTopRight(Vertex src) {
        int i = src.index / 8 + 2, j = src.index % 8 + 1;
        return getVertex(i, j);
    }

    public Vertex getUpLeft(Vertex src) {
        int i = src.index / 8 + 1, j = src.index % 8 - 2;
        return getVertex(i, j);
    }

    public Vertex getUpRight(Vertex src) {
        int i = src.index / 8 + 1, j = src.index % 8 + 2;
        return getVertex(i, j);
    }

    public Vertex getDownLeft(Vertex src) {
        int i = src.index / 8 - 1, j = src.index % 8 - 2;
        return getVertex(i, j);
    }

    public Vertex getDownRight(Vertex src) {
        int i = src.index / 8 - 1, j = src.index % 8 + 2;
        return getVertex(i, j);
    }

    public Vertex getBottomLeft(Vertex src) {
        int i = src.index / 8 - 2, j = src.index % 8 - 1;
        return getVertex(i, j);
    }

    public Vertex getBottomRight(Vertex src) {
        int i = src.index / 8 - 2, j = src.index % 8 + 1;
        return getVertex(i, j);
    }

    public Vertex getVertex(int i, int j) {
        try {
            boolean checkPost = matrix[i][j] == matrix[i][j];
            return list[i * 8 + j];
        } catch (Exception e) {
            return null;
        }
    }
}

class Vertex implements Comparable<Vertex> {

    int label, index, key;
    boolean visited;

    public Vertex(int index, int label) {
        reset();
        this.index = index;
        this.label = label;
    }

    public void visit() {
        visited = true;
    }

    public int compareTo(Vertex other) {
        return key - other.key;
    }

    public void reset() {
        key = Integer.MAX_VALUE;
        visited = false;
    }

    public String toString() {
        return "[ " + label + ", index: " + index + ", Key: " + key + "]";
    }
}
