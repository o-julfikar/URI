package adhoc.p2414;

import java.util.Scanner;

/**
 * @author: Mohammed Julfikar Ali Mahbub, 18301264, CSE Dept, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
 * @Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
 * @URL: https://www.urionlinejudge.com.br/judge/en/problems/view/2414
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = 0;
        while (!sc.hasNext("0")) max = Math.max(max, sc.nextInt());
        System.out.println(max);
    }
}
