package graph.p1085;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author: Mohammed Julfikar Ali Mahbub, 18301264, CSE Dept, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
 * @Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
 * @URL: https://www.urionlinejudge.com.br/judge/en/problems/view/1085
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        while ((T = sc.nextInt()) != 0) {
            String start = sc.next(), end = sc.next();
            Graph graph = new Graph();
            for (int t = 0; t < T; t++) {
                String a = sc.next(), b = sc.next(), weight = sc.next();
                graph.add(a);
                graph.add(b);
                graph.join(a, b, weight);
            }
            try {
                graph.dijkstra(start, end);
            } catch (Exception e) {
                System.out.println("impossivel");
            }
        }
    }
}

class Graph {
    ArrayList<Vertex> vertices;
    HashMap<String, Integer> languages;
    ArrayList<ArrayList<Edge>> list;
    int cursor;
    
    public Graph() {
        vertices = new ArrayList<Vertex>();
        languages = new HashMap<String, Integer>();
        list = new ArrayList<ArrayList<Edge>>();
    }
    
    public void add(String label) {
        if (languages.get(label) == null) {
            languages.put(label, cursor);
            vertices.add(new Vertex(cursor, label));
            list.add(new ArrayList<Edge>());
            cursor++;
        }
    }
    
    public void join(String lang1, String lang2, String word) {
        int idx1 = languages.get(lang1), idx2 = languages.get(lang2);
        list.get(idx1).add(new Edge(vertices.get(idx1), vertices.get(idx2), word));
        list.get(idx2).add(new Edge(vertices.get(idx2), vertices.get(idx1), word));
    }
    
    public void dijkstra(String src, String target) {
        int[] len = new int[cursor];
        for (int i = 0; i < len.length; i++) len[i] = Integer.MAX_VALUE;
        
        PriorityQueue<Vertex> q = new PriorityQueue<Vertex>();
        vertices.get(indexOf(src)).key = 0;
        q.offer(vertices.get(indexOf(src)));
        
        while (!q.isEmpty()) {
            Vertex u = q.poll();
            u.distanceFound = true;
            for (Edge e : list.get(u.position)) {
                Vertex v = e.destination;
                if (!e.traversed && !v.distanceFound && u.keyChar != e.weight.charAt(0) && v.key > u.key + e.weight.length()) {
                    Vertex w = new Vertex(v.position, v.label, u.key + e.weight.length(), e.weight.charAt(0));
                    len[w.position] = Math.min(w.key, len[w.position]);
                    q.offer(w);
                    e.traversed = true;
                }
            }
        }
        int key = len[indexOf(target)];
        if (key == Integer.MAX_VALUE) System.out.println("impossivel");
        else System.out.println(key);
        resetList();
    }
    
    public void view() {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(vertices.get(i).label + ":");
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(" " + list.get(i).get(j).destination.label);
            }
            System.out.println();
        }
    }
    
    public int indexOf(String label) {
        return languages.get(label);
    }
    
    public void resetList() {
        for (Vertex v : vertices) v.reset();
    }
    
    public void resetEdge() {
        for (ArrayList<Edge> list : this.list) for (Edge e : list) e.traversed = false;
    }
}

class Edge {
    Vertex source, destination;
    String weight;
    boolean traversed;
    
    public Edge(Vertex source, Vertex destination, String weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
    
    public String toString() {
        return "Source: " + source + ", Destination: " + destination + " and Weight: " + weight;
    }
}

class Vertex implements Comparable<Vertex> {
    public String label;
    public int position, key = Integer.MAX_VALUE;
    public boolean visited, distanceFound;
    public char keyChar;
    
    public Vertex (int position, String label) {
        this.position = position;
        this.label = label;
    }
    
    public Vertex (int position, String label, int key, char keyChar) {
        this(position, label);
        this.key = key;
        this.keyChar = keyChar;
    }
    
    public int compareTo(Vertex other) {
        return key - other.key;
    }
    
    public void reset() {
        key = Integer.MAX_VALUE;
        visited = false;
        distanceFound = false;
        keyChar = (char) 0;
    }
    
    public String toString() {
        return label;
    }
}