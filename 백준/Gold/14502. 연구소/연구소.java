//벽을 고르는 경우의 수를 구해서 안전구역의 최댓값을 출력
import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int lab[][];
    static int copylab[][];
    static boolean visited[][];
    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {1, 0, -1, 0};
    static Queue<Coord> q = new ArrayDeque<>();
    static int max_room = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lab = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(0);
        System.out.println(max_room);
    }

    private static void DFS(int cnt) {
        if (cnt == 3) {
            BFS();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (lab[i][j] == 0) {
                    lab[i][j] = 1;
                    DFS(cnt+1);
                    lab[i][j] = 0;
                }
            }
        }
    }

    private static void BFS() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (lab[i][j] == 2) {
                    q.offer(new Coord(i, j));
                }
            }
        }

        copylab = new int[N][M];
        for (int i = 0; i < N; i++) {
            copylab[i] = lab[i].clone();
        }

        while (!q.isEmpty()) {
            Coord cur = q.poll();
            int x = cur.x, y = cur.y;

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d], ny = y + dy[d];

                if(nx<0||ny<0||nx>=N||ny>=M) continue;
                if(copylab[nx][ny]==0){
                    copylab[nx][ny]=2;
                    q.add(new Coord(nx,ny));
                }
            }
        }
        checkzone(copylab);
    }

    private static void checkzone(int[][] copyLab) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyLab[i][j] == 0)
                    count++;
            }
        }

        max_room = Math.max(max_room, count);
    }

    private static class Coord {
        int x;
        int y;

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
