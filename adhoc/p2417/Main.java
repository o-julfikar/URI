package adhoc.p2417;

import java.util.Scanner;

/**
 * @author: Mohammed Julfikar Ali Mahbub, 18301264, CSE Dept, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
 * @Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
 * @URL: https://www.urionlinejudge.com.br/judge/en/problems/view/2417
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cWin = sc.nextInt(), cTie = sc.nextInt(), cGoal = sc.nextInt(), fWin = sc.nextInt(), fTie = sc.nextInt(), fGoal = sc.nextInt();
        int cPoint = cWin * 3 + cTie, fPoint = fWin * 3 + fTie;
        if (cPoint > fPoint) {
            System.out.println("C");
        } else if (cPoint < fPoint) {
            System.out.println("F");
        } else {
            if (cGoal > fGoal) {
                System.out.println("C");
            } else if (cGoal < fGoal) {
                System.out.println("F");
            } else {
                System.out.println("=");
            }
        }
    }
}
