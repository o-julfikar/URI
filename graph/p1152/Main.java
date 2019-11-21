package graph.p1152;

import java.io.IOException;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author: Mohammed Julfikar Ali Mahbub, 18301264, CSE Dept, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
 * @Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
 * @URL: https://www.urionlinejudge.com.br/judge/en/problems/view/1152
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int m, n;
        
        while ((m = sc.nextInt()) + (n = sc.nextInt()) > 0) {
            Graph graph = new Graph(m);
            int totalWeight = 0;
            while (n --> 0) {
                graph.join(sc.nextInt(), sc.nextInt(), -totalWeight + (totalWeight += sc.nextInt()));
            }
            System.out.println(totalWeight - graph.prims());
        }
    }
}

class Graph {
    Vertex[] list;
    
    public Graph(int size) {
        list = new Vertex[size];
        for (int i = 0; i < size; i++) {
            list[i] = new Vertex(i);
        }
    }
    
    public void print() {
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
    }
    
    public void printKey() {
        for (Vertex v : list) {
            System.out.print(v.key + " ");
        }
        System.out.println();
    }
    
    public void join(int u, int v, int weight) {
        list[u].adj.add(new Edge(list[u], list[v], weight));
        list[v].adj.add(new Edge(list[v], list[u], weight));
    }
    
    public int prims() {
        int cnt = 0;
        list[0].key = 0;
        PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>();
        for (Vertex v : list) queue.offer(v);
        
        Vertex u;
        
        while (!queue.isEmpty()) {
            u = queue.poll();
            u.visit();
            for (Edge edge : u.adj) {
                if (!list[edge.destination.id].visited && list[edge.destination.id].key > edge.weight) {
                    Vertex v = edge.destination.clone();
                    v.key = edge.weight;
                    list[v.id] = v;
                    queue.offer(v);
                }
            }
        }
        
        for (Vertex v : list) cnt += v.key;
                    
        reset();
        
        return cnt;
    }
    
    public void reset() {
        for (Vertex v : list) v.reset();
    }
}

class Edge {
    Vertex source, destination;
    int weight;
    
    public Edge(Vertex source, Vertex destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
    
    public String toString() {
        return source.id + ":" + destination.id + " (" + weight + ")";
    }
}

class Vertex implements Comparable<Vertex> {
    int key, id;
    boolean visited;
    LinkedList<Edge> adj;
    
    public Vertex(int id) {
        this.id = id;
        adj = new LinkedList<Edge>();
        reset();
    }
    
    public void visit() {
        visited = true;
    }
    
    public int compareTo(Vertex other) {
        return key - other.key;
    }
    
    public void reset() {
        visited = false;
        key = Integer.MAX_VALUE;
    }
    
    public Vertex clone() {
        Vertex copy = new Vertex(id);
        copy.visited = visited;
        copy.adj = adj;
        return copy;
    }
    
    public String toString() {
        return id + ": " + adj;
    }
}

class Pair implements Comparable<Pair>{
    int key;
    Vertex vertex;
    
    public Pair(int key, Vertex vertex) {
        this.key = key;
        this.vertex = vertex;
    }
    
    public int compareTo(Pair other) {
        return key - other.key;
    }
}