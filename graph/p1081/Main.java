package graph.p1081;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author: Mohammed Julfikar Ali Mahbub, 18301264, CSE Dept, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
 * @N.B: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
 * @URL: https://www.urionlinejudge.com.br/judge/en/problems/view/1081
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int n = 1; n <= N; n++) {
            System.out.println("Caso " + n + ":");
            int nodes = sc.nextInt(), edges = sc.nextInt();
            int[][] matrix = new int[nodes][nodes];
            for (int e = 0; e < edges; e++) {
                int a = sc.nextInt(), b = sc.nextInt();
                matrix[a][b] = 1;
            }
            Stack<Integer> st = new Stack<Integer>();
            int[] color = new int[nodes], popped = new int[nodes];
            int u, v;

            for (int i = 0; i < nodes; i++) {
                if (color[i] == 0) {
                    st.push(i);
                    boolean hasChild = false;
                    while (!st.isEmpty()) {
                        v = -1;
                        u = st.peek();
                        color[u] = 1;
                        for (int v1 = 0; v1 < nodes && v < 0; v1++) {
                            if (matrix[u][v1] != 0) {
                                if (color[v1] == 0) {
                                    v = v1;
                                    hasChild = true;
                                    matrix[u][v1] = 0;
                                } else {
                                    matrix[u][v1] = 0;
                                    System.out.printf("%" + (st.size() * 2) + "s%d-%d%n", "", u, v1);
                                }
                            }
                        }
                        if (v < 0) {
                            popped[st.pop()] = 1;
                        } else {
                            System.out.printf("%" + (st.size() * 2) + "s%d-%d pathR(G,%d)%n", "", u, v, v);
                            st.push(v);
                        }
                    }
                    if (hasChild) {
                        System.out.println();
                    }
                }
            }
        }
    }
}
