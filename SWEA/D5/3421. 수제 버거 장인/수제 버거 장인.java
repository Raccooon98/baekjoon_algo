import java.io.*;
import java.util.*;

public class Solution {
    static int ans = 0;
    static int N, M;
    static boolean[][] arr;
    static boolean[] vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());

        for (int t = 1; t <= T; t++) {
            ans = 0;
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if (M == 0) {
                sb.append("#").append(t).append(" ").append(1 << N).append("\n");
                continue;
            }

            arr = new boolean[N + 1][N + 1];
            vis = new boolean[N + 1];

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                arr[a][b] = true;
                arr[b][a] = true;
            }

            DFS(1);
            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.println(sb.toString());
    }

    static void DFS(int idx) {
        if (idx > N) {
            ans++;
            return;
        }

        DFS(idx + 1);

        if (check(idx)) {
            vis[idx] = true;
            DFS(idx + 1);
            vis[idx] = false;
        }
    }

    static boolean check(int n) {

        for (int i = 1; i <= N; i++) {
            if (vis[i] && arr[n][i]) {
                return false;
            }
        }
        return true;
    }
}
