import java.io.*;
import java.util.*;

public class Solution {
    static int N, max, cx, cy;
    static int[][] board;
    static boolean[] check;
    static int[] dx = {1, 1, -1, -1};
    static int[] dy = {1, -1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            max = -1;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            board = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N - 2; i++) {
                for (int j = 0; j < N - 1; j++) {
                    check = new boolean[101];
                    cx = i;
                    cy = j;
                    check[board[i][j]] = true;
                    DFS(i, j, 0, 1);
                }
            }
            sb.append("#").append(t).append(" ").append(max).append("\n");
        }
        System.out.println(sb.toString().trim());
    }

    static void DFS(int x, int y, int dir, int count) {
        boolean flag = false;
        for (int i = dir; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx == cx && ny == cy && count >= 4) {
                max = Math.max(max, count);
                return;
            }

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if (!check[board[nx][ny]]) {
                check[board[nx][ny]] = true;
                DFS(nx, ny, i, count + 1);
                check[board[nx][ny]] = false;
            }
        }
    }
}
