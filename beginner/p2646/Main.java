package beginner.p2646;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author: Mohammed Julfikar Ali Mahbub, 18301264, CSE Dept, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
 * @Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
 * @URL: https://www.urionlinejudge.com.br/judge/en/problems/view/2646
 */
public class Main {
    static HashMap<Character, HashSet<Character>> map = new HashMap<Character, HashSet<Character>>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        map.clear();
        for (char i = 'a'; i <= 'z'; i++) {
            map.put(i, new HashSet<Character>());
        }
        for (int i = 0; i < m; i++) {
            char a = sc.next().charAt(0), b = sc.next().charAt(0);
            map.get(a).add(b);
        }
        
        for (int i = 0; i < n; i++) {
            String first = sc.next(), second = sc.next();
            System.out.println(check(first.toCharArray(), second.toCharArray()) ? "yes" : "no");
        }
    }
    
    public static boolean check(char[] first, char[] second) {
        if (first.length != second.length) return false;
        
        for (int i = 0; i < first.length; i++) {
            if (!((first[i] == second[i]) || bfs(first[i], second[i]))) {
                return false;
            }
        }
        
        return true;
    }
    
    public static boolean bfs(char source, char destination) {
        int[] color = new int[26];
        
        Queue<Character> queue = new LinkedList<Character>();
        queue.offer(source);
        
        char u;
        while (!queue.isEmpty()) {
            u = queue.poll();
            color[u - 'a'] = 1;
            for (char v : map.get(u)) {
                if (color[v - 'a'] == 0) {
                    if (v == destination) {
                        return true;
                    }
                    queue.offer(v);
                }
            }
        }
        
        
        return false;
    }
}
