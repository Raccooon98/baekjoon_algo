import java.io.*;
import java.util.*;

public class Solution {
    static int N, max, maxidx;
    static int[][] board;
    static int[][] vis;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            max = 0;
            maxidx = 2000000;

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            board = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    vis = new int[N][N];
                    int temp = BFS(i, j);

                    if (temp > max) {
                        max = temp;
                        maxidx = board[i][j];
                    } else if (temp == max) {
                        maxidx = Math.min(maxidx, board[i][j]);
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(maxidx).append(" ").append(max).append("\n");
        }

        System.out.println(sb.toString());
    }

    static int BFS(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        vis[x][y] = 1;
        q.offer(new int[]{x, y});

        int cnt = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (vis[nx][ny] != 0) continue;
                if (board[nx][ny] - board[cx][cy] != 1) continue;

                vis[nx][ny] = vis[cx][cy] + 1;
                cnt = Math.max(vis[nx][ny], cnt);
                q.offer(new int[]{nx, ny});
            }
        }
        return cnt;
    }
}
