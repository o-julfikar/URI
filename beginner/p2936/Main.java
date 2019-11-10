package beginner.p2936;

import static java.lang.System.in;
import java.util.Scanner;

/**
 * @author: Mohammed Julfikar Ali Mahbub, 18301264, CSE Dept, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
 * @Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
 * @URL: https://www.urionlinejudge.com.br/judge/en/problems/view/2936
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        int[] p = {300, 1500, 600, 1000, 150};
        int total = 0;
        for (int i = 0; i < p.length; i++) {
            total += p[i] * sc.nextInt();
        }
        System.out.println(total + 225);
    }
}
