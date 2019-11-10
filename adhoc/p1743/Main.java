package adhoc.p1743;

import java.util.Scanner;

/**
 * @author: Mohammed Julfikar Ali Mahbub, 18301264, CSE Dept, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
 * @Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
 * @URL: https://www.urionlinejudge.com.br/judge/en/problems/view/1743
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] x = sc.nextLine().replace(" ", "").toCharArray(), y = sc.nextLine().replace(" ", "").toCharArray();
        System.out.println(x[0] != y[0] && x[1] != y[1] && x[2] != y[2] && x[3] != y[3] && x[4] != y[4] ? "Y" : "N");
    }
}
