import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] board;
    static Queue<Info> q = new ArrayDeque();
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
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num;

                if (num == 1) {
                    q.offer(new Info(i, j));
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

        if (!check) {
            System.out.println(-1);
        } else {
            System.out.println(ans - 1);
        }
    }

    private static int BFS() {
        int max = -1;

        while (!q.isEmpty()) {
            Info cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            max = Math.max(max, board[x][y]);

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (board[nx][ny] == -1) continue;
                if (board[nx][ny] != 0) continue;

                board[nx][ny] = board[x][y] + 1;

                q.offer(new Info(nx, ny));
            }
        }

        return max;
    }

    private static class Info {
        int x, y;

        public Info(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
