import java.io.*;
import java.util.*;

public class Solution {
    static int N, len;
    static int[][] board;
    static List<Coord> cores;
    static int maxCore = 0;
    static int minLine = 0;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            maxCore = 0;
            minLine = Integer.MAX_VALUE;
            cores = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            board = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                    if (board[i][j] == 1) {
                        if (i == 0 || j == 0 || i == N - 1 || j == N - 1) continue;
                        cores.add(new Coord(i, j));
                    }
                }
            }

            len = cores.size();
            simulate(0, 0, 0);
            sb.append("#").append(t).append(" ").append(minLine).append("\n");
        }

        System.out.println(sb.toString().trim());
    }

    static void simulate(int depth, int count, int sum) {
        if (depth == len) {
            if (count > maxCore) {
                maxCore = count;
                minLine = sum;
            } else if (count == maxCore) {
                minLine = Math.min(minLine, sum);
            }
            return;
        }

        Coord cur = cores.get(depth);

        for (int d = 0; d < 4; d++) {
            int cnt = canConnect(cur, d);

            if (cnt > 0) {
                fillBoard(cur, d, 2);
                simulate(depth + 1, count + 1, sum + cnt);
                fillBoard(cur, d, 0);
            }
        }

        simulate(depth + 1, count, sum);
    }

    static int canConnect(Coord cur, int dir) {
        int nx = cur.x + dx[dir];
        int ny = cur.y + dy[dir];
        int count = 0;

        while (nx >= 0 && ny >= 0 && nx < N && ny < N) {
            if (board[nx][ny] != 0) return 0;
            nx += dx[dir];
            ny += dy[dir];
            count++;
        }

        return count;
    }

    static void fillBoard(Coord cur, int dir, int val) {
        int nx = cur.x + dx[dir];
        int ny = cur.y + dy[dir];

        while (nx >= 0 && ny >= 0 && nx < N && ny < N) {
            board[nx][ny] = val;
            nx += dx[dir];
            ny += dy[dir];
        }
    }

    static class Coord {
        int x, y;

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}