import java.io.*;
import java.util.*;

public class Main{
    static int N, M;
    static int[][] board, vis;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        vis = new int[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = input.charAt(j)-'0';
            }
        }

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        vis[0][0] = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (board[nx][ny] == 0) continue;
                if (vis[nx][ny]==0) {
                    vis[nx][ny] = vis[x][y] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        System.out.println(vis[N - 1][M - 1]);
    }
}
