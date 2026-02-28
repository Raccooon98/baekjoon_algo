import java.io.*;
import java.util.*;

public class Main {
    static int[][] board;
    static boolean[][] vis;
    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
    static int w, h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) break;

            board = new int[h][w];
            vis = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (board[i][j] == 1 && !vis[i][j]) {
                        count++;
                        BFS(i, j);
                    }
                }
            }

            sb.append(count).append("\n");
        }
        System.out.println(sb.toString());
    }

    static void BFS(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y});
        vis[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int i = 0; i < 8; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
                if (vis[nx][ny]) continue;
                if (board[nx][ny] == 1 && !vis[nx][ny]) {
                    vis[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }
}
