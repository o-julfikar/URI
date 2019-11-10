package adhoc.p1091;

import java.util.Scanner;

/**
 * @author: Mohammed Julfikar Ali Mahbub, 18301264, CSE Dept, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
 * @Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
 * @URL: https://www.urionlinejudge.com.br/judge/en/runs/add/1091
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k, n, m, x, y;
        while ((k = sc.nextInt()) != 0) {
            n = sc.nextInt();
            m = sc.nextInt();
            for (int i = 0; i < k; i++) {
                x = sc.nextInt();
                y = sc.nextInt();
                if (x > n) {
                    if (y > m) {
                        System.out.println("NE");
                    } else if (y < m) {
                        System.out.println("SE");
                    } else {
                        System.out.println("divisa");
                    }
                } else if (x < n) {
                    if (y > m) {
                        System.out.println("NO");
                    } else if (y < m) {
                        System.out.println("SO");
                    } else {
                        System.out.println("divisa");
                    }
                } else {
                    System.out.println("divisa");
                }
            }
        }
    }
}
