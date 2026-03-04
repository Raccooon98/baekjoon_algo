import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static char[][] board;
    static int[][] mineMap;
    static boolean[][] vis;
    static int dx[] = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int dy[] = {-1, 0, 1, 1, 1, 0, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            board = new char[N][N];
            mineMap = new int[N][N];
            vis = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                String input = br.readLine();
                for (int j = 0; j < N; j++) {
                    board[i][j] = input.charAt(j);
                }
            }

            //각 지점마다 숫자 미리 세놓기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (board[i][j] == '.') {
                        int count = 0;
                        for (int d = 0; d < 8; d++) {
                            int nx = i + dx[d];
                            int ny = j + dy[d];

                            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                            if (board[nx][ny] == '*') count++;
                        }

                        mineMap[i][j] = count;
                    }
                }
            }
            int ans = 0;
            //0인곳을 눌러야 연쇄작용 가능
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (board[i][j] == '.' && mineMap[i][j] == 0 && !vis[i][j]) {
                        BFS(i, j);
                        ans++;
                    }
                }
            }

            //안열린칸도 있을수도 있음
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (board[i][j] == '.' && !vis[i][j]) {
                        ans++;
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.println(sb.toString());
    }

    static void BFS(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y});
        vis[x][y] = true; 

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (mineMap[cur[0]][cur[1]] == 0) {
                for (int i = 0; i < 8; i++) {
                    int nx = cur[0] + dx[i];
                    int ny = cur[1] + dy[i];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= N || vis[nx][ny] || board[nx][ny] == '*') continue;

                    vis[nx][ny] = true;
                    if (mineMap[nx][ny] == 0) {
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
