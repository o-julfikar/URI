package adhoc.p1192;

import java.util.Scanner;

/**
 * @author: Mohammed Julfikar Ali Mahbub, 18301264, CSE Dept, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
 * @Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
 * @URL: https://www.urionlinejudge.com.br/judge/en/problems/view/1192
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n --> 0) {
            char[] in = sc.next().toCharArray();
            int l = in[0] - '0', o = in[1], r = in[2] - '0';
            if (l == r) System.out.println(l * r);
            else if (o >= 'a') System.out.println(l + r);
            else System.out.println(r - l);
        }
    }
}
