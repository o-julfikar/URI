package adhoc.p2454;

import java.util.Scanner;

/**
 * @author: Mohammed Julfikar Ali Mahbub, 18301264, CSE Dept, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
 * @Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
 * @URL: https://www.urionlinejudge.com.br/judge/en/problems/view/2454
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt(), r = sc.nextInt();
        if (p == 1) {
            if (r == 1) {
                System.out.println("A");
            } else {
                System.out.println("B");
            }
        } else {
            System.out.println("C");
        }
    }
}
