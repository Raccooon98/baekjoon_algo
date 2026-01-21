//영역이 무한하다 => 격자 생성 불가능? No
//K를 주기 때문에 범위 어느정도 특정 가능

import java.io.*;
import java.util.*;

public class Solution {
    private static int N, M, K;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static int[][] board;
    private static boolean[][] isAlive;
    private static PriorityQueue<Cell> pq;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            board = new int[N + 2 * K][M + 2 * K];
            isAlive = new boolean[N + 2 * K][M + 2 * K];

            pq = new PriorityQueue<>(((o1, o2) -> o1.activeTime != o2.activeTime ? o1.activeTime - o2.activeTime : o2.X - o1.X));
            int ans = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    int power = Integer.parseInt(st.nextToken());
                    if (power == 0) continue;

                    board[K + i][K + j] = power * 2;
                    isAlive[K + i][K + j] = true;
                    pq.offer(new Cell(K + i, K + j, power, 0));
                }
            }

            simulate(0);

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (isAlive[i][j] && board[i][j] > K)
                        ans++;
                }
            }

            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void simulate(int time) {
        if (time >= K + 1) return;

        while (!pq.isEmpty() && pq.peek().activeTime == time) {
            Cell cur = pq.poll();

            int x = cur.x;
            int y = cur.y;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= board.length || ny >= board[0].length) continue;
                if (board[nx][ny] != 0) continue;
                pq.offer(new Cell(nx, ny, cur.X, time));
                board[nx][ny] = time + cur.X * 2;
                isAlive[nx][ny] = true;
            }
        }

        simulate(time + 1);
    }

    private static class Cell {
        int x, y, X;
        int activeTime;
        int deathTime;

        public Cell(int x, int y, int X, int initTime) {
            this.x = x;
            this.y = y;
            this.X = X;
            this.activeTime = initTime + X + 1;
            this.deathTime = initTime + 2 * X;
        }
    }
}
