import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int dp[][] = new int[30][30];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            sb.append(fac(m, n)).append("\n");
        }

        System.out.println(sb.toString().trim());
    }

    static int fac(int n, int m) {
        if (dp[n][m] > 0) {
            return dp[n][m];
        }

        if (n == m || m == 0) {
            return dp[n][m] = 1;
        }

        return dp[n][m] = fac(n - 1, m - 1) + fac(n - 1, m);
    }
}
