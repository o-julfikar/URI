package adhoc.p2871;

import java.util.Scanner;

/**
 * @author: Mohammed Julfikar Ali Mahbub, 18301264, CSE Dept, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
 * @Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
 * @URL: https://www.urionlinejudge.com.br/judge/en/problems/view/2871
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt(), m = sc.nextInt(), liter = 0;
            for (int i = 0; i < n * m; i++) liter += sc.nextInt();
            System.out.printf("%d saca(s) e %d litro(s)%n", liter / 60, liter % 60);
        }
    }
}
