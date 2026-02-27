import java.util.*;
import java.io.*;

public class Solution {
    static int W, H, N;
    static char[][] board;
    static char[] command;
    static int dir = 0;
    static Tank tank;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            board = new char[H][W];

            for (int i = 0; i < H; i++) {
                String input = br.readLine();
                for (int j = 0; j < W; j++) {
                    board[i][j] = input.charAt(j);
                    if (board[i][j] == '^' || board[i][j] == 'v' || board[i][j] == '<' || board[i][j] == '>')
                        tank = new Tank(i, j, board[i][j]);
                }
            }

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            command = new char[N];

            String input = br.readLine();
            for (int n = 0; n < N; n++) {
                command[n] = input.charAt(n);
            }

            for (char c : command) {
                action(c);
            }

            sb.append("#").append(t).append(" ");
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    sb.append(board[i][j]);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    static void action(char c) {
        int dir = getdir(tank.dir);
        int x = tank.x;
        int y = tank.y;

        if (c == 'U') {
            int nx = x + dx[0];
            int ny = y + dy[0];

            if (nx < 0 || ny < 0 || nx >= H || ny >= W || board[nx][ny] == '*' || board[nx][ny] == '#' || board[nx][ny] == '-') {
                board[x][y] = '^';
                tank.dir = '^';
                return;
            }

            tank.x = nx;
            tank.y = ny;
            board[x][y] = '.';
            board[nx][ny] = '^';
            tank.dir = '^';
            return;
        } else if (c == 'D') {
            int nx = x + dx[1];
            int ny = y + dy[1];

            if (nx < 0 || ny < 0 || nx >= H || ny >= W || board[nx][ny] == '*' || board[nx][ny] == '#' || board[nx][ny] == '-') {
                board[x][y] = 'v';
                tank.dir = 'v';
                return;
            }

            tank.x = nx;
            tank.y = ny;
            board[x][y] = '.';
            board[nx][ny] = 'v';
            tank.dir = 'v';
            return;
        } else if (c == 'L') {
            int nx = x + dx[2];
            int ny = y + dy[2];

            if (nx < 0 || ny < 0 || nx >= H || ny >= W || board[nx][ny] == '*' || board[nx][ny] == '#' || board[nx][ny] == '-') {
                board[x][y] = '<';
                tank.dir = '<';
                return;
            }

            tank.x = nx;
            tank.y = ny;
            board[x][y] = '.';
            board[nx][ny] = '<';
            tank.dir = '<';
            return;
        } else if (c == 'R') {
            int nx = x + dx[3];
            int ny = y + dy[3];

            if (nx < 0 || ny < 0 || nx >= H || ny >= W || board[nx][ny] == '*' || board[nx][ny] == '#' || board[nx][ny] == '-') {
                board[x][y] = '>';
                tank.dir = '>';
                return;
            }

            tank.x = nx;
            tank.y = ny;
            board[x][y] = '.';
            board[nx][ny] = '>';
            tank.dir = '>';
            return;
        } else if (c == 'S') {
            int nx = x, ny = y;
            while (true) {
                nx += dx[dir];
                ny += dy[dir];

                if (nx < 0 || ny < 0 || nx >= H || ny >= W || board[nx][ny] == '#') {
                    nx -= dx[dir];
                    ny -= dy[dir];
                    return;
                }

                if (board[nx][ny] == '*') {
                    board[nx][ny] = '.';
                    return;
                }
            }
        }
    }

    static int getdir(char c) {
        int dir=0;

        if (c == '^') {
            dir = 0;
        } else if (c == 'v') {
            dir = 1;
        } else if (c == '<') {
            dir = 2;
        } else if (c == '>') {
            dir = 3;
        }

        return dir;
    }

    static class Tank {
        int x;
        int y;
        char dir;

        public Tank(int x, int y, char dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
}
