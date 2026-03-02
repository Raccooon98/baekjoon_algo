//체크 했다 안했다 필요 -> 백트래킹/DFS

import java.io.*;
import java.util.*;

public class Main {
    static int R, C, max = 0;
    static char[][] board;
    static boolean[][] vis;
    static boolean[] check = new boolean[26];
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

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

        check[board[0][0] - 'A'] = true;
        vis[0][0] = true;
        DFS(0, 0, 1);

        System.out.println(max);
    }

    static void DFS(int x, int y, int depth) {
        boolean cango = false;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
            if (check[board[nx][ny] - 'A']) continue;
            if (!vis[nx][ny]) {
                vis[nx][ny] = true;
                check[board[nx][ny] - 'A'] = true;
                cango = true;
                DFS(nx, ny, depth + 1);
                check[board[nx][ny] - 'A'] = false;
                vis[nx][ny] = false;
            }
        }

        if (!cango) {
            max = Math.max(max, depth);
            return;
        }
    }
}
