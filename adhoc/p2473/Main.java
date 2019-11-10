package adhoc.p2473;

import java.util.Scanner;

/**
 * @author: Mohammed Julfikar Ali Mahbub, 18301264, CSE Dept, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
 * @Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
 * @URL: https://www.urionlinejudge.com.br/judge/en/problems/view/2473
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] bet = new int[6], draw = new int[6];
        String[] verdict = {"azar", "azar", "azar", "terno", "quadra", "quina", "sena"};
        for (int i = 0; i < bet.length; i++) bet[i] = sc.nextInt();
        for (int i = 0; i < draw.length; i++) draw[i] = sc.nextInt();
        int count = 0;
        for (int i = 0; i < bet.length; i++) {
            for (int j = 0; j < draw.length; j++) {
                if (draw[j] == bet[i]) {
                    count++;
                    break;
                }
            }
        }
        System.out.println(verdict[count]);
    }
}
