import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<Node>[] list;
    static boolean[] vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        vis = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        int sum = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (vis[cur.to]) continue;

            vis[cur.to] = true;
            sum += cur.cost;

            for (Node next : list[cur.to]) {
                if (!vis[next.to]) {
                    pq.offer(next);
                }
            }
        }

        System.out.println(sum);
    }

    static class Node implements Comparable<Node> {
        int to;
        int cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
