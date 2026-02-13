import java.io.*;
import java.util.*;

public class Solution{
    static int N, B;
    static int ans;
    static int[] employee;
    static boolean[] vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());

        for (int t = 1; t <= T; t++) {
            ans = Integer.MAX_VALUE;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            employee = new int[N];
            vis = new boolean[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                employee[i] = Integer.parseInt(st.nextToken());
            }

            func(0, 0);

            sb.append("#").append(t).append(" ").append(ans - B).append("\n");
        }

        System.out.println(sb.toString());
    }

    static void func(int sum, int depth) {
        if (sum >= B) {
            ans = Math.min(ans, sum);
            return;
        }

        if (depth == N) {
            return;
        }

        func(sum + employee[depth], depth + 1);

        func(sum, depth + 1);
    }
}
