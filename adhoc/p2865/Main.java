package adhoc.p2865;

import java.util.Scanner;

/**
 * @author: Mohammed Julfikar Ali Mahbub, 18301264, CSE Dept, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
 * @Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
 * @URL: https://www.urionlinejudge.com.br/judge/en/problems/view/2865
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        while (c-- > 0) {
            int n = sc.nextInt();
            System.out.println(ans(n));
        }
    }

    public static String ans(int n) {
        if (!isPalindrome(toBinary(n))) {
            for (int i = 1; i < n; i++) {
                if (isPalindrome(toBinary(n + i))) {
                    return "+ " + i;
                } else if (isPalindrome(toBinary(n - i))) {
                    return "- " + i;
                } else if (isPalindrome(toBinary(n * i))) {
                    return "x " + i;
                } else if (isPalindrome(toBinary(n / i))) {
                    return "/ " + i;
                }
            }
        }
        return "*";
    }

    public static boolean isPalindrome(String s) {
        char[] c = s.toCharArray();
        for (int i = 0, j = c.length - 1; i < c.length / 2; i++, j--) {
            if (c[i] != c[j]) {
                return false;
            }
        }
        return true;
    }

    public static String toBinary(int n) {
        return trim(toBinaryUtil(n));
    }

    public static String trim(String s) {
        int i = 0;
        for (; i < s.length() && s.charAt(i) == '0'; i++);
        return s.substring(i);
    }

    public static String toBinaryUtil(int n) {
        if (n == 0) {
            return "0";
        }
        return toBinaryUtil(n / 2) + n % 2;
    }
}
