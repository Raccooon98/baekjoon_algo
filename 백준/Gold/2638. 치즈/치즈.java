// 외부공기를 -1로 마스킹 하고 -1 이랑 두개 이상 인접한 치즈만 녹이기?? -> BFS두번이면 가능할듯
// 조건: 모눈종이의 맨 가장자리에는 치즈가 놓이지 않는 것으로 가정한다. -> 0,0에서
import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] board;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        int cheeseCount = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) {
                    cheeseCount++;
                }
            }
        }

        int time = 0;
        while (cheeseCount > 0) {
            time++;

            // 1. 매 시간마다 외부 공기(-1) 마스킹
            markExternalAir();

            // 2. 녹을 치즈들을 찾기
            Queue<Coord> meltCheeseQ = new ArrayDeque<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (board[i][j] == 1) {
                        int airContactCount = 0;
                        for (int d = 0; d < 4; d++) {
                            int nx = i + dx[d];
                            int ny = j + dy[d];
                            if (board[nx][ny] == -1) {
                                airContactCount++;
                            }
                        }
                        if (airContactCount >= 2) {
                            meltCheeseQ.offer(new Coord(i, j));
                        }
                    }
                }
            }

            // 3. 녹을 치즈가 없으면 종료
            if (meltCheeseQ.isEmpty()) {
                break;
            }

            // 4. 찾은 치즈들을 녹여서 0으로 바꾸고 치즈 개수 감소
            while (!meltCheeseQ.isEmpty()) {
                Coord cur = meltCheeseQ.poll();
                board[cur.x][cur.y] = 0;
                cheeseCount--;
            }
        }

        System.out.println(time);
    }

    public static void markExternalAir() {
        boolean[][] visited = new boolean[N][M];
        Queue<Coord> airQueue = new ArrayDeque<>();

        // 보드의 0인 부분을 -1로 마스킹하기 전에, 이전 턴의 -1을 0으로 초기화
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(board[i][j] == -1) {
                    board[i][j] = 0;
                }
            }
        }

        airQueue.offer(new Coord(0, 0));
        visited[0][0] = true;
        board[0][0] = -1;

        while (!airQueue.isEmpty()) {
            Coord cur = airQueue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (visited[nx][ny] || board[nx][ny] == 1) continue;

                airQueue.offer(new Coord(nx, ny));
                visited[nx][ny] = true;
                board[nx][ny] = -1;
            }
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