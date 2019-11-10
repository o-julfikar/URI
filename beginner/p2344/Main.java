package beginner.p2344;

import java.util.Scanner;

/**
 * @author: Mohammed Julfikar Ali Mahbub, 18301264, CSE Dept, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
 * @Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
 * @URL: https://www.urionlinejudge.com.br/judge/en/problems/view/2344
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n > 85) System.out.println("A");
        else if (n > 60) System.out.println("B");
        else if (n > 35)System.out.println("C");
        else if (n > 0) System.out.println("D");
        else System.out.println("A");
    }
}
