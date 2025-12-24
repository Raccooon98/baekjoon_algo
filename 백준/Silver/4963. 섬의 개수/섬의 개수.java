import java.io.*;
import java.util.*;

public class Main {
    static int[][] board;
    static boolean[][] vis;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int w, h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

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

            int ans = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!vis[i][j] && board[i][j] == 1) {
                        DFS(i, j);
                        ans++;
                    }
                }
            }

            sb.append(ans).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void DFS(int x, int y) {
        vis[x][y] = true;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
            if (board[nx][ny] == 1 && !vis[nx][ny]) {
                DFS(nx, ny);
            }
        }
    }
}
