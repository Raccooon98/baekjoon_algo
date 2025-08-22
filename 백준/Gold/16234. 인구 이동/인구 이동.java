import java.io.*;
import java.util.*;

public class Main {
    static int N, L, R;
    static int board[][];
    static boolean vis[][];

    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {1, 0, -1, 0,};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;

        while (true) {
            boolean move = false;
            vis = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!vis[i][j] && BFS(i, j)) {
                        move = true;
                    }
                }
            }
            if (!move) break;
            cnt++;
        }

        System.out.println(cnt);
    }

    static boolean BFS(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, y});
        vis[x][y] = true;
        int sum = board[x][y];
        int count = 1;

        List<int[]> node = new ArrayList<>();
        node.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int p[] = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p[0] + dx[i], ny = p[1] + dy[i];
                //귀찮아서 그냥 안에 있는 경우로 구현
                if (0 <= nx && nx < N && 0 <= ny && ny < N && !vis[nx][ny]) {
                    int diff = Math.abs(board[p[0]][p[1]] - board[nx][ny]);
                    if (L <= diff && diff <= R) {
                        vis[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                        sum += board[nx][ny];
                        count++;
                        node.add(new int[]{nx, ny});
                    }
                }
            }
        }

        if (count > 1) {
            int avg = sum / count;
            for (int[] n : node) {
                board[n[0]][n[1]] = avg;
            }
            return true;
        }
        return false;
    }
}
