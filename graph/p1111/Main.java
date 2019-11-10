package graph.p1111;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author: Mohammed Julfikar Ali Mahbub, 18301264, CSE Dept, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
 * @Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
 * @URL: https://www.urionlinejudge.com.br/judge/en/problems/view/1111
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N;
        while ((N = sc.nextInt()) != 0) {
            Graph graph = new Graph(N);
            for (int i = N - 1; i >= 0; i--) {
                for (int j = 0; j < N; j++) {
                    int north, south, west, east;
                    north = sc.nextInt();
                    south = sc.nextInt();
                    west = sc.nextInt();
                    east = sc.nextInt();
                    Vertex u = graph.getVertex(i, j);
                    if (north == 1) {
                        u.add(graph.getVertex(i + 1, j));
                    }
                    if (south == 1) {
                        u.add(graph.getVertex(i - 1, j));
                    }
                    if (west == 1) {
                        u.add(graph.getVertex(i, j - 1));
                    }
                    if (east == 1) {
                        u.add(graph.getVertex(i, j + 1));
                    }
                }
            }

            int p = sc.nextInt();
            while (p-- > 0) {
                int x0 = sc.nextInt(), y0 = sc.nextInt(), x1 = sc.nextInt(), y1 = sc.nextInt();
                graph.show(y0, x0, y1, x1);
            }
            System.out.println();
        }

    }
}

class Graph {

    Vertex[] vertices;

    public Graph(int size) {
        vertices = new Vertex[size * size];
        for (int i = 0; i < vertices.length; i++) {
            vertices[i] = new Vertex(i, i / size, i % size);
        }
    }

    public Vertex getVertex(int i, int j) {
        try {
            int size = (int) Math.sqrt(vertices.length);
            return vertices[i * size + j];
        } catch (Exception e) {
            return null;
        }
    }

    public void show(int i, int j, int k, int l) {
        Vertex source = getVertex(i, j), destination = getVertex(k, l);
        source.key = 0;
        PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>();
        for (Vertex v : vertices) {
            queue.offer(v);
        }

        while (!queue.isEmpty()) {
            Vertex u = queue.poll();
            u.visit();
            for (Vertex v : u.adj) {
                if (!v.visited && v.key > u.key + 1) {
                    v.key = u.key + 1;
                    queue.remove(v);
                    queue.offer(v);
                }
            }
        }
        if (destination.key == Integer.MAX_VALUE || destination.key < 0) System.out.println("Impossible");
        else System.out.println(destination.key);
        
        for (Vertex v : vertices) v.reset();
    }
}

class Vertex implements Comparable<Vertex> {

    public int i, j, index, key;
    public boolean visited;
    public LinkedList<Vertex> adj = new LinkedList<Vertex>();

    public Vertex(int index, int i, int j) {
        reset();
        this.index = index;
        this.i = i;
        this.j = j;
    }

    public void visit() {
        visited = true;
    }

    public void add(Vertex v) {
        adj.add(v);
    }

    public int compareTo(Vertex other) {
        return key - other.key;
    }

    public void reset() {
        visited = false;
        key = Integer.MAX_VALUE;
    }

    public String toString() {
        return "[ i: " + i + ", j: " + j + ", index: " + index + ", key: " + key;
    }
}
