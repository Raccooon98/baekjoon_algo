//한칸씩 움직이는 DFS로 하려고 했는데 생각해보니까 맨헤튼 거리로 이동했다고 치고 백트래킹만 해보기

import java.util.*;
import java.io.*;

public class Solution {
    static int SX, SY, EX, EY, N;
    static int[][] employee;
    static int[][] board;
    static boolean[] vis;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            vis = new boolean[N];
            employee = new int[N][2];

            st = new StringTokenizer(br.readLine());
            SX = Integer.parseInt(st.nextToken());
            SY = Integer.parseInt(st.nextToken());
            EX = Integer.parseInt(st.nextToken());
            EY = Integer.parseInt(st.nextToken());

            ans = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                employee[i][0] = Integer.parseInt(st.nextToken());
                employee[i][1] = Integer.parseInt(st.nextToken());
            }

            DFS(SX, SY, 0, 0);

            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.println(sb.toString());
    }

    static void DFS(int x, int y, int cnt, int depth) {
        if (depth >= N) {
            int dist = getDistance(x, y, EX, EY);
            ans = Math.min(ans, dist + cnt);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (vis[i]) continue;
            vis[i] = true;
            int next = cnt + getDistance(x, y, employee[i][0], employee[i][1]);
            DFS(employee[i][0], employee[i][1], next, depth + 1);
            vis[i] = false;
        }
    }

    static int getDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
