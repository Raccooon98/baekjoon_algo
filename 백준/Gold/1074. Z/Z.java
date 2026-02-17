import java.io.*;
import java.util.*;

public class Main {
    static int N, r, c;
    static int cnt = 0;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int len = 1 << N;
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        func(0, 0, len);
        
    }

    static void func(int x, int y, int n) {
        if (x == r && y == c) {
            System.out.println(cnt);
            return;
        }

        if (r < x + n && r >= x && c < y + n && c >= y) {
            func(x, y, n / 2);
            func(x, y + n / 2, n / 2);
            func(x + n / 2, y, n / 2);
            func(x + n / 2, y + n / 2, n / 2);
        } else {
            cnt += n * n;
        }
    }
}
