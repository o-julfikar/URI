package graph.p1123;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author: Mohammed Julfikar Ali Mahbub, 18301264, CSE Dept, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
 * @Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
 * @URL: https://www.urionlinejudge.com.br/judge/en/problems/view/1123
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N, M, C, K, U, V, P;

        while ((N = sc.nextInt()) != 0 && (M = sc.nextInt()) != 0 && (C = sc.nextInt()) != 0 && (K = sc.nextInt()) != 0) {
            Graph graph = new Graph(N);

            for (int i = 0; i < N; i++) {
                graph.create();
            }

            for (int e = 0; e < M; e++) {
                U = sc.nextInt();
                V = sc.nextInt();
                P = sc.nextInt();
                graph.join(U, V, P);
            }

            graph.show(K, C - 1);
        }
    }
}

class Graph {

    Vertex[] vertices;
    int[][] matrix;
    int cursor;

    public Graph(int size) {
        vertices = new Vertex[size];
        matrix = new int[size][size];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = -1;
            }
        }
    }

    public void create() {
        vertices[cursor] = new Vertex(cursor++);
    }

    public void join(int start, int end, int weight) {
        matrix[start][end] = matrix[end][start] = weight;
    }

    public void show(int source, int destination) {
        int[] keys = new int[vertices.length];

        for (int i = 1; i < keys.length; i++) {
            keys[i] = keys[i - 1] + matrix[i - 1][i];
        }

        PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>();

        Vertex u;

        vertices[source].key = 0;

        for (Vertex v : vertices) {
            queue.offer(v);
        }

        while (!queue.isEmpty()) {
            u = queue.poll();
            u.visit();
            if (u.index < destination) {
                if (vertices[destination].key > u.key + keys[destination] - keys[u.index] && u.key + keys[destination] - keys[u.index] >= 0) {
                    vertices[destination].key = u.key + keys[destination] - keys[u.index];
                    queue.remove(vertices[destination]);
                    queue.offer(vertices[destination]);
                }
                continue;
            }

            for (int i = 0; i < matrix[u.index].length; i++) {
                if (!vertices[i].visited && matrix[u.index][i] >= 0 && vertices[i].key > u.key + matrix[u.index][i]) {
                    vertices[i].key = u.key + matrix[u.index][i];
                    queue.remove(vertices[i]);
                    queue.offer(vertices[i]);
                }
            }
        }

        System.out.println(vertices[destination].key);

        for (Vertex v : vertices) {
            v.reset();
        }
    }
}

class Vertex implements Comparable<Vertex> {

    int index, key;
    boolean visited;

    public Vertex(int index) {
        this.index = index;
        reset();
    }

    public void visit() {
        this.visited = true;
    }

    public void reset() {
        this.visited = false;
        this.key = Integer.MAX_VALUE;
    }

    public int compareTo(Vertex other) {
        return key - other.key;
    }

    public String toString() {
        return "[ Index: " + index + ", Key: " + key;
    }
}
