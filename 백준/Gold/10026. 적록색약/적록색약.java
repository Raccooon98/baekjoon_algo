import java.io.*;
import java.util.*;

public class Main{
    static int N;
    static char[][] board;
    static boolean[][] vis;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        board = new char[N][N];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = input.charAt(j);
            }
        }

        vis = new boolean[N][N];
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!vis[i][j]) {
                    BFS(i, j);
                    count++;
                }
            }
        }
        sb.append(count).append(" ");

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 'G')
                    board[i][j] = 'R';
            }
        }

        vis = new boolean[N][N];
        count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!vis[i][j]) {
                    BFS(i, j);
                    count++;
                }
            }
        }
        sb.append(count).append(" ");

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

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (vis[nx][ny]) continue;
                if (board[cx][cy] == board[nx][ny]) {
                    q.offer(new int[]{nx, ny});
                    vis[nx][ny] = true;
                }
            }
        }
    }
}
