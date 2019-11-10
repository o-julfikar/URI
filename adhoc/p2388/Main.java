package adhoc.p2388;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author: Mohammed Julfikar Ali Mahbub, 18301264, CSE Dept, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
 * @Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
 * @URL: https://www.urionlinejudge.com.br/judge/en/problems/view/2388
 */
public class Main {
    public static void main(String[] args) {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        try {
            int n = Integer.parseInt(reader.readLine());
            int distance = 0;
            
            while (n --> 0) {
                String line = reader.readLine();
                StringTokenizer token = new StringTokenizer(line);
                int v = Integer.parseInt(token.nextToken()), t = Integer.parseInt(token.nextToken());
                distance += v * t;
            }
            
            System.out.println(distance);
        } catch (IOException ioe) {
            
        }
        
    }
}
