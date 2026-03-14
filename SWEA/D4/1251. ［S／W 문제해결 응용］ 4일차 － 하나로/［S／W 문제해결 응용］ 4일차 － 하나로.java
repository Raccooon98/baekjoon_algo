import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static double tax;
    static Island[] islands;
    static int[] parent, rank;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            parent = new int[N];
            rank = new int[N];
            islands = new Island[N];

            for (int i = 0; i < N; i++) {
                parent[i] = i;
            }

            StringTokenizer stX = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                islands[i] = new Island();
                islands[i].x = Long.parseLong(stX.nextToken()); // 좌표는 long 추천
            }
            StringTokenizer stY = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                islands[i].y = Long.parseLong(stY.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            tax = Double.parseDouble(st.nextToken());

            PriorityQueue<Node> pq = new PriorityQueue<>();
            for (int i = 0; i < N; i++) {
                Island cur = islands[i];
                for (int j = 0; j < N; j++) {
                    if (i == j) continue;
                    Island next = islands[j];

                    long dist = (long) (cur.x - next.x) * (cur.x - next.x) + (long) (cur.y - next.y) * (cur.y - next.y);
                    double cost = dist * tax;

                    pq.offer(new Node(i, j, cost));
                }
            }

            double sum = 0;
            int cnt = 0;
            while (!pq.isEmpty()) {
                Node cur = pq.poll();

                if (union(cur.from, cur.to)) {
                    sum += cur.cost;
                    cnt++;
                    if (cnt == N - 1) break;
                }
            }

            sb.append("#").append(t).append(" ").append(Math.round(sum)).append("\n");
        }

        System.out.println(sb.toString().trim());
    }

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static boolean union(int a, int b) {

        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) return false;

        if (rank[rootA] < rank[rootB]) {
            parent[rootA] = rootB;
        } else if (rank[rootA] > rank[rootB]) {
            parent[rootB] = rootA;
        } else {
            parent[rootB] = rootA;
            rank[rootA]++;
        }

        return true;
    }

    static class Island {
        long x, y;

        public Island() {

        }

        public Island(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Node implements Comparable<Node> {
        int from, to;
        double cost;

        public Node(int from, int to, double cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        public int compareTo(Node o) {
            return Double.compare(this.cost, o.cost);
        }
    }
}
