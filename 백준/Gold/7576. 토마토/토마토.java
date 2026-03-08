import java.io.*;
import java.util.*;

public class Main{
    static int N, M;
    static Queue<int[]> q = new ArrayDeque<>();
    static int[][] board;
    static int[][] vis;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 1) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        int ans = BFS();
        boolean check = true;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0) {
                    check = false;
                }
            }
        }

        System.out.println(check == true ? ans - 1 : -1);
    }

    static int BFS() {
        int max = -1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            max = Math.max(max, board[cx][cy]);

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (board[nx][ny] != 0) continue;
                if (board[nx][ny] == -1) continue;

                board[nx][ny] = board[cx][cy] + 1;
                q.offer(new int[]{nx, ny});

            }
        }

        return max;
    }
}
