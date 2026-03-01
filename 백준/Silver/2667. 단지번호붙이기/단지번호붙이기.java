import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] board;
    static boolean[][] vis;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static StringBuilder sb = new StringBuilder();
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        board = new int[N][N];
        vis = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = input.charAt(j) - '0';
                if (board[i][j] == 1) board[i][j] = -1;
            }
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == -1 && vis[i][j] == false) {
                    cnt++;
                    BFS(i, j, cnt);
                }
            }
        }
        sb.append(cnt).append("\n");
        Collections.sort(result);
        for (int n : result) {
            sb.append(n).append("\n");
        }

        System.out.println(sb.toString());
    }

    static void BFS(int x, int y, int num) {
        Queue<int[]> q = new ArrayDeque<>();
        vis[x][y] = true;
        board[x][y] = num;
        q.offer(new int[]{x, y});

        int count = 1;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (vis[nx][ny]) continue;
                if (board[nx][ny] == -1) {
                    vis[nx][ny] = true;
                    board[nx][ny] = num;
                    count++;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        result.add(count);
    }
}
