package beginner.p2631;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author: Mohammed Julfikar Ali Mahbub, 18301264, CSE Dept, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
 * @Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
 * @URL: https://www.urionlinejudge.com.br/judge/en/problems/view/2631
 */
public class Main {
    static int[] parent;
    static int[] key;
    
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        
        int n, m, q;
        String line, ln = "";
        
        while ((line = reader.readLine()) != null) {
            System.out.print(ln);
            ln = "\n";
            StringTokenizer st = new StringTokenizer(line);
            if (line.equals("")) break;
            n = Integer.parseInt(st.nextToken()) + 1;
            m = Integer.parseInt(st.nextToken());
            q = Integer.parseInt(st.nextToken());
            parent = new int[n];
            key = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                key[i] = 1;
            }
            for (int i = 0; i < m; i++) {
                String[] input = reader.readLine().split("\\s+");
                int x = Integer.parseInt(input[0]), y = Integer.parseInt(input[1]);
                union(x, y);
            }
            for (int i = 0; i < q; i++) {
                String[] input = reader.readLine().split("\\s+");
                int a = Integer.parseInt(input[0]), b = Integer.parseInt(input[1]);
                if (find(a) == find(b)) {
                    System.out.println("S");
                } else {
                    System.out.println("N");
                }
            }             
        }
    }
    
    public static void union(int a, int b) {
        int parentA = find(a), parentB = find(b);
        if (key[parentA] > key[parentB]) {
            parent[parentB] = parentA;
            key[parentA] = key[parentA] + key[parentB];
        } else {
            parent[parentA] = parentB;
            key[parentB] = key[parentB] + key[parentA];
        }
    }
    
    public static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }
}
