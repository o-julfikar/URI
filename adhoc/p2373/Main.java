package adhoc.p2373;

import java.util.Scanner;

/**
 * @author: Mohammed Julfikar Ali Mahbub, 18301264, CSE Dept, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
 * @Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
 * @URL: https://www.urionlinejudge.com.br/judge/en/problems/view/2373
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), broken = 0;
        while (n --> 0) {
            int cans = sc.nextInt(), cups = sc.nextInt();
            if (cans > cups) {
                broken += cups;
            }
        }
        System.out.println(broken);
    }
}
