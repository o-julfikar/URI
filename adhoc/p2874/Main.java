package adhoc.p2874;

import java.util.Scanner;

/**
 * @author: Mohammed Julfikar Ali Mahbub, 18301264, CSE Dept, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
 * @Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
 * @URL: https://www.urionlinejudge.com.br/judge/en/problems/view/2874
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            while (n --> 0) print(sc.next());
            System.out.println();
        }
    }
    
    public static void print(String n) {
        System.out.print(alpha(n));
        
    }
    
    public static char alpha(String n) {
        return (char) toDecimal(n);
    }
    
    public static int toDecimal(String n) {
        if (n.equals("0") || n.length() == 0) return 0;
        return (n.charAt(0) - '0') * (int) Math.pow(2, n.length() - 1) + toDecimal(n.substring(1));
    }
}
