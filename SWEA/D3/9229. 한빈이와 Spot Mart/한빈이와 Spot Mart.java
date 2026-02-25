import java.io.*;
import java.util.*;

public class Solution {
    static int N, M, ans;
    static int[] a;
    static boolean[] vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            ans = -1;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            a = new int[N];
            vis = new boolean[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            DFS(0, 0);
            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.println(sb.toString());
    }

    static void DFS(int depth, int sum) {
        if (depth >= 2) {
            if (sum <= M) {
                ans = Math.max(ans, sum);
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (vis[i]) continue;
            vis[i] = true;
            DFS(depth + 1, sum + a[i]);
            vis[i] = false;
        }
    }
}
