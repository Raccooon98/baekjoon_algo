import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int board[][];
    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {1, 0, -1, 0};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new int[N][N];

        ArrayList<Virus> virus = new ArrayList<>();
        Queue<Virus> q;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] != 0) {
                    virus.add(new Virus(i, j, board[i][j], 0));
                }
            }
        }

        Collections.sort(virus);
        q = new ArrayDeque<>(virus);

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        while (!q.isEmpty()) {
            Virus cur = q.poll();
            if (cur.time >= S) continue;
            int x = cur.x, y = cur.y, type = cur.type, time = cur.time;

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d], ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (board[nx][ny] != 0) continue;
                board[nx][ny] = board[x][y];
                q.add(new Virus(nx, ny, board[x][y], time + 1));
            }
        }

        System.out.println(board[X - 1][Y - 1]);
    }

    private static class Virus implements Comparable<Virus> {
        int x, y, type, time;

        public Virus(int x, int y, int type, int time) {
            this.x = x;
            this.y = y;
            this.type = type;
            this.time = time;
        }

        @Override
        public int compareTo(Virus o) {
            return this.type - o.type;
        }
    }
}
