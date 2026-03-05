import java.io.*;
import java.util.*;

public class Solution {
    static int N, M, K;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Cell> cells;
    //1상 2하 3좌 4우
    static int[] dx = {0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            cells = new ArrayList<>();

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int amount = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());
                cells.add(new Cell(x, y, amount, dir));
            }

            int sum = 0;
            for (int m = 0; m < M; m++) {
                sum = 0;
                //0 총합 1 최댓값 2 최댓값일때 방향
                int[][][] board = new int[N][N][3];
                for (Cell cur : cells) {
                    if (cur.amount == 0) continue;

                    cur.x += dx[cur.dir];
                    cur.y += dy[cur.dir];

                    if (cur.x == 0 || cur.y == 0 || cur.x == N - 1 || cur.y == N - 1) {
                        cur.amount /= 2;
                        cur.dir = reverse(cur.dir);
                    }

                    if (cur.amount == 0) continue;

                    if (board[cur.x][cur.y][0] == 0) {
                        board[cur.x][cur.y][0] = cur.amount;
                        board[cur.x][cur.y][1] = cur.amount;
                        board[cur.x][cur.y][2] = cur.dir;
                    } else {//갱신
                        board[cur.x][cur.y][0] += cur.amount;
                        if (board[cur.x][cur.y][1] < cur.amount) {
                            board[cur.x][cur.y][1] = cur.amount;
                            board[cur.x][cur.y][2] = cur.dir;
                        }
                    }
                }

                cells.clear();
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (board[i][j][0] > 0) {
                            sum += board[i][j][0];
                            cells.add(new Cell(i, j, board[i][j][0], board[i][j][2]));
                        }
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(sum).append("\n");
        }

        System.out.println(sb.toString().trim());
    }

    static int reverse(int dir) {
        if (dir == 1) return 2;
        if (dir == 2) return 1;
        if (dir == 3) return 4;
        else return 3;
    }

    static class Cell {
        int x;
        int y;
        int dir;
        int amount;

        public Cell(int x, int y, int amount, int dir) {
            this.x = x;
            this.y = y;
            this.amount = amount;
            this.dir = dir;
        }
    }
}
