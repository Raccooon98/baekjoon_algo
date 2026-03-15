import java.io.*;
import java.util.*;

public class Main{
    static int N;
    static int[][] board;
    static int[][] temp;
    static boolean[][] vis;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        board = new int[N][N];
        temp = new int[N][N];

        int minheight = 101, maxheight = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                minheight = Math.min(minheight, board[i][j]);
                maxheight = Math.max(maxheight, board[i][j]);
            }
        }

        int max = 1;
        for (int h = minheight; h <= maxheight; h++) {
            for (int n = 0; n < N; n++) {
                temp[n] = Arrays.copyOf(board[n], N);
            }

            markWater(h);

            vis = new boolean[N][N];
            int count = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (temp[i][j] != 0 && !vis[i][j]) {
                        markZone(i, j, h);
                        count++;
                    }
                }
            }

            max = Math.max(max, count);
        }

        System.out.println(max);
    }

    static void markWater(int num) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (temp[i][j] <= num) {
                    temp[i][j] = 0;
                }
            }
        }
    }

    static void markZone(int x, int y, int num) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y});
        vis[x][y] = true;
        temp[x][y] = num;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (vis[nx][ny]) continue;
                if (temp[nx][ny] != 0) {
                    vis[nx][ny] = true;
                    temp[nx][ny] = num;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }
}
