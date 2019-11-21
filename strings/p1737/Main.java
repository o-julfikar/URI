package strings.p1737;

import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author: Mohammed Julfikar Ali Mahbub, 18301264, CSE Dept, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
 * @Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
 * @URL: https://www.urionlinejudge.com.br/judge/en/problems/view/1737
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        while ((n = sc.nextInt()) != 0) {
            TreeMap<String, Integer> digram = new TreeMap<String, Integer>();
            String prev = sc.nextLine();
            int len = 0;
            for (int i = 0; i < n; i++) {
                char[] line = (prev.concat(sc.nextLine())).toCharArray();
                len += line.length - prev.length();
                for (int j = 0; j < line.length - 1; j++) {
                    String key = "" + line[j] + line[j + 1];
                    digram.put(key, digram.getOrDefault(key, 0) + 1);
                }
                prev = String.valueOf(line[line.length - 1]);
            }

            Entry<String, Integer> entrySet[] = new Entry[0];
            entrySet = digram.entrySet().toArray(entrySet);
            
            for (int i = 0; i < entrySet.length && i < 5; i++) {
                int maxIndex = i;
                for (int j = i + 1; j < entrySet.length; j++) {
                    if (entrySet[j].getValue() > entrySet[maxIndex].getValue()) {
                        maxIndex = j;
                    }
                }
                if (i != maxIndex) {
                    Entry<String, Integer> temp = entrySet[i];
                    entrySet[i] = entrySet[maxIndex];
                    entrySet[maxIndex] = temp;
                }
            }
            
            for (int i = 0; i < 5; i++) {
                System.out.printf("%s %d %.6f\n", entrySet[i].getKey(), entrySet[i].getValue(), (double) entrySet[i].getValue() / (len - 1));
            }
            
            
            System.out.println();
        }
    }
}
