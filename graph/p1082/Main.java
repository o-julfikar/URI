package graph.p1082;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeSet;

/**
 * @author: Mohammed Julfikar Ali Mahbub, 18301264, CSE Dept, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
 * @Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
 * @URL: https://www.urionlinejudge.com.br/judge/en/problems/view/1082
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            System.out.println("Case #" + t + ":");
            int V = sc.nextInt(), E = sc.nextInt();
            HashMap<Character, LinkedList<Character>> graph = new HashMap<Character, LinkedList<Character>>();
            for (char c = 'a'; c < 'a' + V; c++) {
                graph.put(c, new LinkedList<Character>());
            }
            for (int e = 0; e < E; e++) {
                char a = sc.next().charAt(0), b = sc.next().charAt(0);
                graph.get(a).add(b);
                graph.get(b).add(a);
            }
            int[] color = new int['z' + 1];
            Stack<Character> st = new Stack<Character>();
            LinkedList<TreeSet<Character>> components = new LinkedList<TreeSet<Character>>();
            for (char c = 'a'; c < 'a' + V; c++) {
                if (color[c] == 0) {
                    components.add(new TreeSet<Character>());
                    st.push(c);
                    while (!st.isEmpty()) {
                        char u = st.peek(), v = 'X';
                        color[u] = 1;
                        if (!components.getLast().contains(u)) {
                            components.getLast().add(u);
                        }
                        for (char v1 : graph.get(u)) {
                            if (color[v1] == 0) {
                                v = v1;
                                break;
                            }
                        }
                        if (v == 'X') {
                            st.pop();
                        } else {
                            st.push(v);
                        }
                    }
                }
            }
            for (TreeSet<Character> list : components) {
                for (Character c : list) {
                    System.out.print(c + ",");
                }
                System.out.println();
            }
            System.out.println(components.size() + " connected components");
            System.out.println();
        }
    }
}
