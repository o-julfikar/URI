package adhoc.p2381;

import java.util.Scanner;

/**
 * @author: Mohammed Julfikar Ali Mahbub, 18301264, CSE Dept, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
 * @Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
 * @URL: https://www.urionlinejudge.com.br/judge/en/problems/view/2381
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        String[] students = new String[n];
        for (int i = 0; i < n; i++) students[i] = sc.next();
        sort(students, 0, students.length - 1);
        System.out.println(students[k - 1]);
    }
    
    public static void sort(String[] a, int start, int end) {
        if (start >= end) return;
        int partitionIndex = partition(a, start, end);
        sort(a, start, partitionIndex - 1);
        sort(a, partitionIndex + 1, end);
    }
    
    public static int partition(String[] a, int start, int end) {
        String pivot = a[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (a[j].compareTo(pivot) < 0) {
                a[j] = swap(a[i + 1], a[i + 1] = a[j]);
                i++;
            }
        }
        a[i + 1] = swap(a[end], a[end] = a[i + 1]);
        return i + 1;
    }
    
    public static String swap(String a, String b) {
        return a;
    }
}
