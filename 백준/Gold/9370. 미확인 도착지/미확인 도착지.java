import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 200000000;
    static int T;
    static int n, m, t, s, g, h;
    static ArrayList<Node> adj[];
    static ArrayList<Integer> candidates;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            adj = new ArrayList[n + 1];
            for (int i = 0; i <= n; i++) {
                adj[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                adj[a].add(new Node(b,d));
                adj[b].add(new Node(a,d));
            }

            candidates = new ArrayList<>();
            for (int i = 0; i < t; i++) {
                candidates.add(Integer.parseInt(br.readLine()));
            }

            long[] distS = dijkstra(s);
            long[] distG = dijkstra(g);
            long[] distH = dijkstra(h);

            List<Integer> result = new ArrayList<>();
            for (int candidate : candidates) {
                long path1 = distS[g] + distG[h] + distH[candidate];
                long path2 = distS[h] + distH[g] + distG[candidate];
                if (distS[candidate] == path1 || distS[candidate] == path2) {
                    result.add(candidate);
                }
            }

            Collections.sort(result);

            for (int i = 0; i < result.size(); i++) {
                sb.append(result.get(i) + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static long[] dijkstra(int start) {
        long[] dist = new long[n + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int curIndex = cur.index;
            long curDistance = cur.distance;

            if (dist[curIndex] < curDistance) {
                continue;
            }

            for (Node next : adj[curIndex]) {
                if (dist[curIndex] + next.distance < dist[next.index]) {
                    dist[next.index] = dist[curIndex] + next.distance;
                    pq.add(new Node(next.index, dist[next.index]));
                }
            }
        }
        return dist;
    }

    private static class Node implements Comparable<Node> {
        int index;
        long distance;

        public Node(int index, long distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.distance, o.distance);//비교함수써보기
        }
    }
}
