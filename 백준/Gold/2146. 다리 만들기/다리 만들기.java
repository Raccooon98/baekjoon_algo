import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int board[][];
    static boolean visit[][];
//    static Queue<int[]> q = new ArrayDeque<>();

    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        visit = new boolean[N][N];

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) {//섬에 1번 부터 번호를 붙일거라 -1로 초기화
                    board[i][j] = -1;
                }
            }
        }

        int cnt = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == -1 && !visit[i][j]) {
                    mask_island(i, j, cnt);
                    cnt++;
                }
            }
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 1; i <= cnt; i++) {
            ans = Math.min(ans, BFS(i));
        }


        System.out.println(ans);
    }

    private static void mask_island(int x, int y, int cnt) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y});
        visit[x][y] = true;
        board[x][y] = cnt;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (!visit[nx][ny] && board[nx][ny] == -1) {
                    visit[nx][ny] = true;
                    board[nx][ny] = cnt;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }

    private static int BFS(int num) {
        Queue<int[]> q = new ArrayDeque<>();
        visit = new boolean[N][N];
        int sum = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == num) {
                    visit[i][j] = true;
                    q.offer(new int[]{i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = cur[0] + dx[d];
                    int ny = cur[1] + dy[d];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                    if (board[nx][ny] != 0 && board[nx][ny] != num)
                        return sum;
                    else if(board[nx][ny]==0&&!visit[nx][ny]){
                        visit[nx][ny]=true;
                        q.offer(new int[]{nx,ny});
                    }
                }
            }

            sum++;
        }
        return Integer.MAX_VALUE;
    }
}
