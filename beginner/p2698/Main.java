package beginner.p2698;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author: Mohammed Julfikar Ali Mahbub, 18301264, CSE Dept, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
 * @Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
 * @URL: https://www.urionlinejudge.com.br/judge/en/problems/view/2698
 */
public class Main {

    public static int[] col, key;

    public static void main(String[] args) throws IOException {
        int l, c, n, p, x, a, b, s, m1, m2;
        Reader sc = new Reader();

        l = sc.nextInt();
        c = sc.nextInt();
        n = sc.nextInt();
        col = new int[l];
        key = new int[c + 1];
        key[0] = l;

        for (int i = 0; i < n; i++) {
            p = sc.nextInt() - 1;
            x = sc.nextInt() - 1;
            a = sc.nextInt();
            b = sc.nextInt();

            s = key[p];
//            print(key);
//            System.out.println(s);
            m1 = (a % l + ((s % l) * (s % l)) % l) % l;
            m2 = (a % l + ((s % l + b % l) * (s % l + b % l) % l)) % l;
//            System.out.println("M1: " + m1 + ", M2: " + m2);
            
            for (int j = Math.min(m1, m2), k = Math.max(m1, m2); j <= k; j++) {
                key[col[j]]--;
                col[j] = x;
            }
            key[x] += Math.abs(m1 - m2) + 1;
//        print(key);
        }
//        print(key);
        System.out.println(countMax());
    }

    public static void print(int[] a) {
        System.out.println(java.util.Arrays.toString(a));
    }

    public static int countMax() {
        int max = key[0];
        for (int i = 1; i < key.length; i++) {
            if (key[i] > max) {
                max = key[i];
            }
        }

        return max;
    }
}

class Reader {

    final private int BUFFER_SIZE = 1 << 16;
    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;

    public Reader() {
        din = new DataInputStream(System.in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public Reader(String file_name) throws IOException {
        din = new DataInputStream(new FileInputStream(file_name));
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public String readLine() throws IOException {
        byte[] buf = new byte[64]; // line length 
        int cnt = 0, c;
        while ((c = read()) != -1) {
            if (c == '\n') {
                break;
            }
            buf[cnt++] = (byte) c;
        }
        return new String(buf, 0, cnt);
    }

    public int nextInt() throws IOException {
        int ret = 0;
        byte c = read();
        while (c <= ' ') {
            c = read();
        }
        boolean neg = (c == '-');
        if (neg) {
            c = read();
        }
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');

        if (neg) {
            return -ret;
        }
        return ret;
    }

    public long nextLong() throws IOException {
        long ret = 0;
        byte c = read();
        while (c <= ' ') {
            c = read();
        }
        boolean neg = (c == '-');
        if (neg) {
            c = read();
        }
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        if (neg) {
            return -ret;
        }
        return ret;
    }

    public double nextDouble() throws IOException {
        double ret = 0, div = 1;
        byte c = read();
        while (c <= ' ') {
            c = read();
        }
        boolean neg = (c == '-');
        if (neg) {
            c = read();
        }

        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');

        if (c == '.') {
            while ((c = read()) >= '0' && c <= '9') {
                ret += (c - '0') / (div *= 10);
            }
        }

        if (neg) {
            return -ret;
        }
        return ret;
    }

    private void fillBuffer() throws IOException {
        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
        if (bytesRead == -1) {
            buffer[0] = -1;
        }
    }

    private byte read() throws IOException {
        if (bufferPointer == bytesRead) {
            fillBuffer();
        }
        return buffer[bufferPointer++];
    }

    public void close() throws IOException {
        if (din == null) {
            return;
        }
        din.close();
    }
}
