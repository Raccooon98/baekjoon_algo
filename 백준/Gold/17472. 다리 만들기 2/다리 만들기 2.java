import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] board;
    static boolean[][] vis;
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static int[] parent, rank;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        vis = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) board[i][j] = -1;
            }
        }

        int count = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == -1 && !vis[i][j]) {
                    maskMap(count, i, j);
                    count++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] > 0) {
                    for (int d = 0; d < 4; d++) {
                        findBridge(i, j, d, board[i][j]);
                    }
                }
            }
        }

        parent = new int[count];
        rank = new int[count];
        for (int i = 1; i < count; i++) {
            parent[i] = i;
        }

        int cnt = 0;
        int ans = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (union(cur.from, cur.to)) {
                ans += cur.cost;
                cnt++;
            }
        }

        if (cnt == count - 2) {
            System.out.println(ans);
        }else{
            System.out.println(-1);
        }

    }

    //맵에 섬별로 마스킹 하기
    static void maskMap(int num, int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            board[cx][cy] = num;
            vis[cx][cy] = true;

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (vis[nx][ny]) continue;
                if (board[nx][ny] != 0 && !vis[nx][ny]) {
                    board[nx][ny] = num;
                    vis[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }

    static void findBridge(int x, int y, int dir, int start) {
        int dist = 0;
        int nx = x;
        int ny = y;

        while (true) {
            nx += dx[dir];
            ny += dy[dir];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) break;
            if (board[nx][ny] == start) break;

            if (board[nx][ny] == 0) {
                dist++;
            } else {
                if (dist >= 2) {
                    pq.offer(new Node(start, board[nx][ny], dist));
                }
                break;
            }
        }
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) return false;
        else {
            if (rank[rootA] < rank[rootB]) {
                parent[rootA] = rootB;
            } else if (rank[rootB] < rank[rootA]) {
                parent[rootB] = rootA;
            } else {
                parent[rootB] = rootA;
                rank[rootA]++;
            }
            return true;
        }
    }

    static class Node implements Comparable<Node> {
        int from, to;
        int cost;

        public Node(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
