package custom.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author: Mohammed Julfikar Ali Mahbub, 18301264, CSE Dept, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
 * @Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
 * @URL:
 */
public class Reader {

    BufferedReader br;
    StringTokenizer tokenizer;

    public Reader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }
    
    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreElements()) {
            try {
                tokenizer = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        return tokenizer.nextToken();
    }
    
    public int nextInt() {
        return Integer.parseInt(next());
    }
    
    public long nextLone() {
        return Long.parseLong(next());
    }
    
    public double nextDouble() {
        return Double.parseDouble(next());
    }
    
    public String nextLine() {
        String str = "";
        
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return str;
    }
}
