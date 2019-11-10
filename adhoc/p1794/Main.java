package adhoc.p1794;

import java.util.Scanner;

/**
 * @author: Mohammed Julfikar Ali Mahbub, 18301264, CSE Dept, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
 * @Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
 * @URL: https://www.urionlinejudge.com.br/judge/en/problems/view/1794
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), la = sc.nextInt(), lb = sc.nextInt(), sa = sc.nextInt(), sb = sc.nextInt();
        System.out.println(n >= la && n <= lb && n >= sa && n <= sb ? "possivel" : "impossivel");
    }
}
