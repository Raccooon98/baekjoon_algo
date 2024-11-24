import java.util.*;

public class Main {
    static int N, M, result = 0;
    static int[][] Map;
    static boolean[][] vis;
    static int[] parent;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static List<int[]> bridge = new ArrayList<>();
    static List<int[]> v = new ArrayList<>();

    static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            if (a < b) parent[b] = a;
            else parent[a] = b;
        }
    }

    static boolean sameParent(int a, int b) {
        return find(a) == find(b);
    }

    // 각 섬에 번호 매기기
    static void countIsland(int x, int y, int num) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        vis[x][y] = true;
        Map[x][y] = num;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int cx = curr[0], cy = curr[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (!vis[nx][ny] && Map[nx][ny] == -1) {
                    vis[nx][ny] = true;
                    Map[nx][ny] = num;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }

    // 입력받은 방향대로 다리 만들기
    static void makeBridge(int x, int y, int dir) {
        int len = 0;
        int startPoint = Map[x][y];

        while (true) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) break; // 범위 초과 검사
            if (Map[nx][ny] == 0) {
                x = nx;
                y = ny;
                len++;
            } else if (len >= 2 && startPoint != Map[nx][ny]) {
                if (startPoint != 0 && Map[nx][ny] != 0) { // 유효한 값인지 확인
                    bridge.add(new int[]{len, startPoint, Map[nx][ny]});
                }
                break;
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        Map = new int[N][M];
        vis = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Map[i][j] = sc.nextInt();
                if (Map[i][j] == 1) {
                    Map[i][j] = -1;
                    v.add(new int[]{i, j});
                }
            }
        }

        int cnt = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (Map[i][j] == -1 && !vis[i][j]) {
                    countIsland(i, j, cnt);
                    cnt++;
                }
            }
        }

        for (int[] point : v) {
            int x = point[0], y = point[1];
            for (int i = 0; i < 4; i++) {
                makeBridge(x, y, i);
            }
        }

        bridge.sort(Comparator.comparingInt(o -> o[0])); // 다리 길이 기준으로 정렬

        parent = new int[cnt + 1];
        for (int i = 1; i <= cnt; i++) {
            parent[i] = i; // Union-Find 초기화
        }

        for (int[] b : bridge) {
            int len = b[0], start = b[1], dest = b[2];
            if (!sameParent(start, dest)) {
                union(start, dest);
                result += len;
            }
        }

        // 모든 섬이 연결되었는지 확인
        for (int i = 1; i < cnt; i++) {
            if (find(i) != find(1)) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(result);
    }
}
