import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static int time = 0, ans = 0;
    static int[][] board;
    static boolean[][] vis;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int cheese = -1;
        while (true) {
            if (cheese == 0) break;

            cheese = 0;
            vis = new boolean[R][C];
            Queue<int[]> q = new ArrayDeque<>();
            q.offer(new int[]{0, 0});

            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int x = cur[0];
                int y = cur[1];

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                    if (board[nx][ny] == 1) {
                        board[nx][ny] = 0;
                        vis[nx][ny] = true;
                        cheese++;
                    } else {
                        if (!vis[nx][ny]) {
                            vis[nx][ny] = true;
                            q.offer(new int[]{nx, ny});
                        }
                    }
                }
            }

            time++;
            if (cheese != 0)
                ans = cheese;
        }
        sb.append(time-1).append("\n").append(ans);
        System.out.println(sb.toString());
    }
}
