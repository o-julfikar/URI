package graph.p1076;

import static java.lang.System.in;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author: Mohammed Julfikar Ali Mahbub, 18301264, CSE Dept, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
 * @N.B: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int start = sc.nextInt(), vertices = sc.nextInt(), edges = sc.nextInt();
            int[][] matrix = new int[vertices][vertices];
            for (int i = 0; i < edges; i++) {
                int a = sc.nextInt(), b = sc.nextInt();
                matrix[a][b] = matrix[b][a] = 1;
            }

            int time = 0;
            Stack<Integer> stack = new Stack<Integer>();
            int[] color = new int[vertices];
            color[start] = 1;
            stack.push(start);
            int u, v = -1;
            
            while (!stack.isEmpty()) {
                v = -1;
                u = stack.peek();
                time++;
                for (int _v = 0; _v < matrix[u].length; _v++) {
                    if (matrix[u][_v] != 0 && color[_v] == 0) {
                        v = _v;
                        break;
                    }
                }
                if (v < 0) {
                    stack.pop();
                } else {
                    color[v] = 1;
                    stack.push(v);
                }
            }
            System.out.println(time - 1);
        }
    }
}
