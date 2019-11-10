package adhoc.p1761;

import java.util.Scanner;

/**
 * @author: Mohammed Julfikar Ali Mahbub, 18301264, CSE Dept, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
 * @Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
 * @URL: https://www.urionlinejudge.com.br/judge/en/problems/view/1761
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextDouble()) {
            double a = sc.nextDouble(), b = sc.nextDouble(), c = sc.nextDouble();
            System.out.printf("%.2f%n", 5 * (b * Math.tan(Math.PI * a / 180) + c));
        }
    }
}
