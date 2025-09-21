import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char board[][];
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = s.charAt(j);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                min = Math.min(min, check(i, j));
            }
        }

        System.out.println(min);
    }

    private static int check(int x, int y) {
        int cnt = 0;
        char color = board[x][y];

        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if (board[i][j] != color) {
                    cnt++;
                }
                if (color == 'W') {
                    color = 'B';
                } else {
                    color = 'W';
                }
            }
            if (color == 'W') {
                color = 'B';
            } else {
                color = 'W';
            }
        }

        return Math.min(cnt,64-cnt);
    }
}
