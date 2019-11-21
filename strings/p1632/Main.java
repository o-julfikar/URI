package strings.p1632;

import java.util.Scanner;

/**
 * @author: Mohammed Julfikar Ali Mahbub, 18301264, CSE Dept, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
 * @Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
 * @URL: https://www.urionlinejudge.com.br/judge/en/problems/view/1632
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] key = new int[26];
        key[0] = key['e' - 'a'] = key['i' - 'a'] = key['o' - 'a'] = key['s' - 'a'] = 1;
        while (t --> 0) {
            char[] s = sc.next().toCharArray();
            int cnt = 1;
            for (char c : s) cnt *= key[c % 32 - 1] + 2;
            System.out.println(cnt);
        }
    }
}
