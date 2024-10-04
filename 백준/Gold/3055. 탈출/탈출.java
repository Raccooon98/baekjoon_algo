import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int R, C, Dx, Dy;
    static char[][] Map;
    static int[][] vis;
    static Queue<Coord> sq, wq;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        Map = new char[R][C];
        vis = new int[R][C];
        sc.nextLine();
        for (int[] tmp : vis) {
            Arrays.fill(tmp, -1);
        }

        sq = new LinkedList<>();
        wq = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < C; j++) {
                Map[i][j] = s.charAt(j);
                if (Map[i][j] == 'D') {
                    Dx = i;
                    Dy = j;
                }
                if (Map[i][j] == 'S') {
                    sq.add(new Coord(i, j));
                    vis[i][j] = 0;
                }
                if (Map[i][j] == '*') {
                    wq.add(new Coord(i, j));
                }
            }
        }

        while (!sq.isEmpty()) {
            // 물 먼저 확산하기
            int wsize = wq.size();
            for (int i = 0; i < wsize; i++) {
                Coord cur = wq.poll();
                int cx = cur.x, cy = cur.y;

                for (int d = 0; d < 4; d++) {
                    int nx = cx + dx[d], ny = cy + dy[d];
                    if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                    if (Map[nx][ny] == 'X' || Map[nx][ny] == 'S' || Map[nx][ny] == 'D') continue;
                    if (Map[nx][ny] == '.') {
                        Map[nx][ny] = '*';
                        wq.add(new Coord(nx, ny));
                    }
                }
            }

            // sq 사이즈만큼 BFS로 조사해서 최단거리 계산
            int ssize = sq.size();
            for (int i = 0; i < ssize; i++) {
                Coord cur = sq.poll();
                int cx = cur.x, cy = cur.y;

                for (int d = 0; d < 4; d++) {
                    int nx = cx + dx[d], ny = cy + dy[d];
                    if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                    if (Map[nx][ny] == 'X' || Map[nx][ny] == '*' || vis[nx][ny] != -1) continue;
                    if (Map[nx][ny] == 'D') {
                        System.out.println(vis[cx][cy] + 1);
                        return;
                    }
                    if (Map[nx][ny] == '.') {
                        vis[nx][ny] = vis[cx][cy] + 1;
                        sq.add(new Coord(nx, ny));
                    }
                }
            }
        }

        System.out.println("KAKTUS");
    }

    static class Coord {
        int x, y;

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}