package adhoc.p1573;

import java.util.Scanner;

/**
 * @author: Mohammed Julfikar Ali Mahbub, 18301264, CSE Dept, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
 * @Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
 * @URL: https://www.urionlinejudge.com.br/judge/en/problems/view/1573
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b, c;
        while ((a = sc.nextInt()) + (b = sc.nextInt()) + (c = sc.nextInt()) > 0) {
            System.out.println((int) Math.pow(a * b * c, 1.0 / 3));
        }
    }
}
