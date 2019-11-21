package adhoc.p2875;

import java.util.Scanner;

/**
 * @author: Mohammed Julfikar Ali Mahbub, 18301264, CSE Dept, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
 * @Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
 * @URL: https://www.urionlinejudge.com.br/judge/en/problems/view/2875
 */
public class Main {

    public static final int UP = 0, LEFT = 1, DOWN = 2, RIGHT = 3;
    public static int direction;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt(), m = sc.nextInt(), x = 0, y = 0, count[] = new int[2];
            int[][] arr = new int[n][m];
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (sc.hasNextInt()) {
                        count[arr[i][j] = sc.nextInt()]++;
                    } else {
                        arr[i][j] = -1;
                        sc.next();
                        x = i;
                        y = j;
                    }
                }
            }

            direction = DOWN;
            while (count[0] > 0) {
                if (front(arr, x, y)) {
                    arr[x][y] = 1;
                    System.out.print("F ");
                    switch (direction) {
                        case UP:
                            x--;
                            break;
                        case DOWN:
                            x++;
                            break;
                        case LEFT:
                            y++;
                            break;
                        case RIGHT:
                            y--;
                            break;
                    }
                    count[0]--;
                } else if (left(arr, x, y)) {
                    turnLeft();
                } else if (right(arr, x, y)) {
                    turnRight();
                }
            }
            System.out.println("E");
        }
    }

    public static void turnLeft() {
        System.out.print("L ");
        direction = (4 + direction - 1) % 4;
    }

    public static void turnRight() {
        System.out.print("R ");
        direction = (direction + 1) % 4;
    }

    public static boolean front(int[][] a, int i, int j) {
        if (direction == UP) {
            return val(a, i - 1, j) == 0;
        } else if (direction == DOWN) {
            return val(a, i + 1, j) == 0;
        } else if (direction == LEFT) {
            return val(a, i, j + 1) == 0;
        } else {
            return val(a, i, j - 1) == 0;
        }
    }

    public static boolean left(int[][] a, int i, int j) {
        if (direction == UP) {
            return val(a, i, j - 1) == 0;
        } else if (direction == DOWN) {
            return val(a, i, j + 1) == 0;
        } else if (direction == LEFT) {
            return val(a, i - 1, j) == 0;
        } else {
            return val(a, i + 1, j) == 0;
        }
    }

    public static boolean right(int[][] a, int i, int j) {
        if (direction == UP) {
            return val(a, i, j + 1) == 0;
        } else if (direction == DOWN) {
            return val(a, i, j - 1) == 0;
        } else if (direction == LEFT) {
            return val(a, i + 1, j) == 0;
        } else {
            return val(a, i - 1, j) == 0;
        }
    }

    public static int val(int[][] a, int i, int j) {
        try {
            return a[i][j];
        } catch (Exception e) {
            return -1;
        }
    }
}
