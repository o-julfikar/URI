package adhoc.p1250;

import java.util.Scanner;

/**
 * @author: Mohammed Julfikar Ali Mahbub, 18301264, CSE Dept, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
 * @Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
 * @URL: https://www.urionlinejudge.com.br/judge/en/problems/view/1250
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n --> 0) {
            int s = sc.nextInt();
            int[] height = new int[s];
            char[] action = null;
            for (int i = 0; i < s; i++) height[i] = sc.nextInt();
            action = sc.next().toCharArray();
            int hit = 0;
            for (int i = 0; i < s; i++) {
                hit += ((action[i] == 'S' && height[i] < 3) || (action[i] == 'J' && height[i] > 2)) ? 1 : 0;
            }
            System.out.println(hit);
        }
    }
}
