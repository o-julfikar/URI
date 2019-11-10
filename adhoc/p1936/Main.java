package adhoc.p1936;

import java.util.Scanner;

/**
 * @author: Mohammed Julfikar Ali Mahbub, 18301264, CSE Dept, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
 * @Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
 * @URL: https://www.urionlinejudge.com.br/judge/en/problems/view/1936
 */
public class Main {

    public static int[] fact = {1, 2, 6, 24, 120, 720, 5040, 40320};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        while (n != 0) {
            int i = getDivisor(n);
            count += n / fact[i];
            n %= fact[i];
        }
        System.out.println(count);
    }

    public static int getDivisor(int n) {
        for (int i = 7; i >= 0; i--) {
            if (fact[i] <= n) {
                return i;
            }
        }

        return -1;
    }
}
