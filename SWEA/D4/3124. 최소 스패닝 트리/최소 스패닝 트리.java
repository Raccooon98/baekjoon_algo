import java.io.*;
import java.util.*;

public class Solution{
    static int V, E;
    static int[] parent;
    static int[] rank;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            parent = new int[V + 1];
            for (int i = 1; i <= V; i++) {
                parent[i] = i;
            }
            rank = new int[V + 1];

            PriorityQueue<Node> pq = new PriorityQueue<>();
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                pq.offer(new Node(from, to, cost));
            }

            long sum = 0;
            int cnt = 0;

            while (!pq.isEmpty()) {
                Node cur = pq.poll();

                if (union(cur.from, cur.to)) {
                    sum += cur.cost;
                    cnt++;
                    if (cnt == V - 1) break;
                }
            }

            sb.append("#").append(t).append(" ").append(sum).append("\n");
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

    static class Node implements Comparable<Node> {
        int from, to, cost;

        public Node(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
