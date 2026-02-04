import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static int[][] chart;
    static boolean[] vis;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            ans = Integer.MAX_VALUE;
            N = Integer.parseInt(br.readLine());
            chart = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    chart[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            vis = new boolean[N];
            DFS(0, 0);

            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }

        System.out.println(sb.toString());
    }

    static void DFS(int depth, int cur) {
        if (depth == N / 2) {
            cal();
            return;
        }

        for (int i = cur; i < N; i++) {
            if (vis[i]) continue;

            vis[i] = true;
            DFS(depth + 1, i);
            vis[i] = false;
        }
    }

    static void cal() {
        int sumA = 0;
        int sumB = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) continue;

                if (vis[i] && vis[j]) {
                    sumA += chart[i][j];
                } else if (!vis[i] && !vis[j]) {
                    sumB += chart[i][j];
                }
            }
        }

        int diff = Math.abs(sumA - sumB);
        ans = Math.min(ans, diff);
    }
}
