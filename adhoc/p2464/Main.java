package adhoc.p2464;

import java.util.Scanner;

/**
 * @author: Mohammed Julfikar Ali Mahbub, 18301264, CSE Dept, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
 * @Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
 * @URL: https://www.urionlinejudge.com.br/judge/en/problems/view/2464
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        char[] key = sc.next().toCharArray();
        char[] msg = sc.next().toCharArray();
        for (char c : msg) System.out.print(key[c - 'a']);
        System.out.println();
    }
}
