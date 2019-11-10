package adhoc.p2455;

import java.util.Scanner;

/**
 * @author: Mohammed Julfikar Ali Mahbub, 18301264, CSE Dept, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
 * @Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
 * @URL: https://www.urionlinejudge.com.br/judge/en/problems/view/2455
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p1 = sc.nextInt(), c1 = sc.nextInt(), p2 = sc.nextInt(), c2 = sc.nextInt();
        if (p1 * c1 < p2 * c2) System.out.println("1");
        else if (p1 * c1 > p2 * c2) System.out.println("-1");
        else System.out.println("0");
    }
}
