import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char board[][], checked[][];
    static int dx[] = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int dy[] = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        board = new char[N][N];
        checked = new char[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            board[i] = s.toCharArray();
        }

        Queue<int[]> q = new ArrayDeque<>();

        boolean isDead = false;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            checked[i] = s.toCharArray();
            for (int j = 0; j < N; j++) {
                if (checked[i][j] == 'x') {
                    q.add(new int[]{i, j});
                    if (board[i][j] == '*')
                        isDead = true;
                    else {
                        int cnt = 0;
                        for (int d = 0; d < 8; d++) {
                            int nx = i + dx[d], ny = j + dy[d];
                            if (0 <= nx && nx < N && 0 <= ny && ny < N && board[nx][ny] == '*') cnt++;
                        }
                        checked[i][j] = (char) (cnt + '0');
                    }
                }
            }
        }

        if (isDead) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (board[i][j] == '*') {
                        checked[i][j] = '*';
                    }
                }
            }
        } else {
            while (!q.isEmpty()) {
                int cur[] = q.poll();
                int x = cur[0];
                int y = cur[1];
                int cnt = 0;

                for (int d = 0; d < 8; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                    if (board[nx][ny] == '*')
                        cnt++;
                }

                checked[x][y] = (char)(cnt+'0');
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(checked[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
