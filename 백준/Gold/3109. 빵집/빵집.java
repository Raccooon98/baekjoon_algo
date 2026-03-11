import java.io.*;
import java.util.*;

public class Main {
    static int R, C, ans = 0;
    static char[][] board;
    static boolean[][] vis;
    static int[] dx = {-1, 0, 1};
    static int[] dy = {1, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        vis = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = input.charAt(j);
            }
        }

        for (int i = 0; i < R; i++) {
            vis[i][0] = true;
            if (DFS(i, 0)) {
                ans++;
            }
        }

        System.out.println(ans);
    }

    static boolean DFS(int r, int depth) {
        if (depth >= C - 1) {
            return true;
        }

        for (int i = 0; i < 3; i++) {
            int nx = r + dx[i];
            int ny = depth + dy[i];

            if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
            if (vis[nx][ny]) continue;
            if (board[nx][ny] == 'x') continue;
            if (board[nx][ny] == '.') {
                vis[nx][ny] = true;
                if (DFS(nx, ny)) return true;
            }
        }

        return false;
    }
}
