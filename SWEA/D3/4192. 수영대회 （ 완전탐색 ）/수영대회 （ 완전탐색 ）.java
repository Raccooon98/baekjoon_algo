import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static int sx, sy, fx, fy;
    static int[][] vis;
    static int[][] board;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            board = new int[N][N];
            vis = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            st = new StringTokenizer(br.readLine());
            sx = Integer.parseInt(st.nextToken());
            sy = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            fx = Integer.parseInt(st.nextToken());
            fy = Integer.parseInt(st.nextToken());

            BFS();

            sb.append("#").append(t).append(" ").append(vis[fx][fy]-1).append("\n");
        }

        System.out.println(sb.toString().trim());
    }

    static void BFS() {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sx, sy});
        vis[sx][sy] = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (vis[nx][ny] != 0) continue;
                if (board[nx][ny] == 1) continue;

                q.offer(new int[]{nx, ny});
                vis[nx][ny] = vis[cur[0]][cur[1]] + 1;
            }
        }
    }
}
