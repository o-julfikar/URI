package graph.p1128;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Stack;

/**
 * @author: Mohammed Julfikar Ali Mahbub, 18301264, CSE Dept, BRAC University, Mohakhali Campus, Dhaka, Bangladesh
 * @Note: Do not copy the code or use it in any illegal activity. Only use if required for learning purpose.
 * @URL: https://www.urionlinejudge.com.br/judge/en/problems/view/1128
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Reader sc = new Reader();
        
        int n, m;
        while ((n = sc.nextInt()) + (m = sc.nextInt()) > 0) {
            Graph graph = new Graph(n);
            while (m --> 0) {
                graph.joinVertex(sc.nextInt(), sc.nextInt(), sc.nextInt() == 2);
            }
            System.out.println(ans(graph.scc()));
        }
    }

    public static int ans(boolean yes) {
        return yes ? 1 : 0;
    }
}

class Graph {

    int[] color;
    HashSet<Integer>[] list;
    Stack<Integer> stack;

    public Graph(int size) {
        size = size + 1;
        color = new int[size];
        list = new HashSet[size];
        stack = new Stack<Integer>();
        for (int i = 0; i < list.length; i++) {
            list[i] = new HashSet<Integer>();
        }
    }

    public void joinVertex(int u, int v, boolean dual) {
        if (dual) {
            list[u].add(v);
            list[v].add(u);
        } else {
            list[u].add(v);
        }
    }

    public boolean scc() {
        for (int i = 1; i < list.length; i++) {
            if (color[i] == 0) {
                dfs(i);
            }
        }

        list = reverse(list);

        int comp = 0;
        while (!stack.isEmpty()) {
            int u = stack.pop();
            if (color[u] == 1) {
                comp++;
                if (comp > 1) {
                    return false;
                }
                createComponent(u);
            }
        }

        return comp == 1;
    }

    public void dfs(int u) {
        color[u] = 1;
        for (int v : list[u]) {
            if (color[v] == 0) {
                dfs(v);
            }
        }
        stack.push(u);
    }

    public void createComponent(int u) {
        color[u] = 0;
        for (int v : list[u]) {
            if (color[v] == 1) {
                createComponent(v);
            }
        }
    }

    public HashSet<Integer>[] reverse(HashSet<Integer>[] source) {
        HashSet<Integer>[] list = new HashSet[source.length];
        for (int i = 0; i < list.length; i++) {
            list[i] = new HashSet<Integer>();
        }

        for (int i = 0; i < source.length; i++) {
            for (int j : source[i]) {
                list[j].add(i);
            }
        }

        return list;
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
