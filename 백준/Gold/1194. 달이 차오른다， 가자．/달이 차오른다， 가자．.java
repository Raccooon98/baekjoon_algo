import java.util.*;

public class Main {
    static int N, M, result;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static Node player;
    static char[][] Map;
    static boolean[][][] vis;
    static Queue<Node> q;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();

        Map = new char[N][M];
        vis = new boolean[N][M][64];

        for (int i = 0; i < N; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < M; j++) {
                Map[i][j] = s.charAt(j);
                if (Map[i][j] == '0') {
                    player = new Node(i, j, 0, 0);
                }
            }
        }
        q = new LinkedList<>();
        System.out.println(BFS());
    }

    static public int BFS() {
        q.add(player);
        vis[player.x][player.y][0] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (Map[cur.x][cur.y] == '1') // 현재 위치에서 목표점 확인
                return cur.cost;

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d], ny = cur.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (Map[nx][ny] == '#' || vis[nx][ny][cur.key]) continue;

                if (Map[nx][ny] >= 'a' && Map[nx][ny] <= 'f') { // 열쇠 획득
                    int nkey = cur.key | (1 << (Map[nx][ny] - 'a')); // 새로운 열쇠를 추가
                    if (!vis[nx][ny][nkey]) { // 새로운 열쇠로 방문하지 않은 곳
                        vis[nx][ny][nkey] = true;
                        q.add(new Node(nx, ny, nkey, cur.cost + 1));
                    }
                } else if (Map[nx][ny] >= 'A' && Map[nx][ny] <= 'F') { // 문
                    if ((cur.key & (1 << (Map[nx][ny] - 'A'))) != 0) { // 키가 있으면 문을 열 수 있음
                        if (!vis[nx][ny][cur.key]) {
                            vis[nx][ny][cur.key] = true;
                            q.add(new Node(nx, ny, cur.key, cur.cost + 1));
                        }
                    }
                } else { // 그냥 이동
                    if (!vis[nx][ny][cur.key]) {
                        vis[nx][ny][cur.key] = true;
                        q.add(new Node(nx, ny, cur.key, cur.cost + 1));
                    }
                }
            }
        }
        return -1; // 목표 지점에 도달할 수 없는 경우
    }

    static class Node {
        int x, y, key, cost;

        public Node(int x, int y, int key, int cost) {
            this.x = x;
            this.y = y;
            this.key = key;
            this.cost = cost;
        }
    }
}