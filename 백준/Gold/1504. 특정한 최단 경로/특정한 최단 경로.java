import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static int N, E;
    public static ArrayList<Info>[] adj;
    public static int[] d;
    public static int INF = Integer.MAX_VALUE;

    public static class Info implements Comparable<Info> {
        int idx;
        int distance;

        public Info(int distance, int idx) {
            this.idx = idx;
            this.distance = distance;
        }

        @Override
        public int compareTo(Info o) {
            return Integer.compare(this.distance, o.distance);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        E = sc.nextInt();
        adj = new ArrayList[N + 1];  // 1-based index를 사용하기 위해 N+1로 설정

        for (int i = 1; i <= N; ++i) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; ++i) {
            int a, b, c;
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();

            adj[a].add(new Info(c, b));
            adj[b].add(new Info(c, a));
        }

        int mid1 = sc.nextInt();
        int mid2 = sc.nextInt();

        int[] distFrom1 = dijkstra(1);  // 1번 노드에서 각 노드로의 거리
        int[] distFromMid1 = dijkstra(mid1);  // mid1 노드에서 각 노드로의 거리
        int[] distFromMid2 = dijkstra(mid2);  // mid2 노드에서 각 노드로의 거리

        long result1 = (long) distFrom1[mid1] + distFromMid1[mid2] + distFromMid2[N];
        long result2 = (long) distFrom1[mid2] + distFromMid2[mid1] + distFromMid1[N];

        long ans = Math.min(result1, result2);
        if (ans >= INF) ans = -1;

        System.out.println(ans);
    }

    public static int[] dijkstra(int start) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);

        PriorityQueue<Info> pq = new PriorityQueue<>();
        pq.add(new Info(0, start));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Info top = pq.poll();
            int curDist = top.distance;
            int curIdx = top.idx;

            if (curDist > dist[curIdx]) continue;

            for (Info edge : adj[curIdx]) {
                int nextDist = edge.distance;
                int nextIdx = edge.idx;

                if (dist[nextIdx] > dist[curIdx] + nextDist) {
                    dist[nextIdx] = dist[curIdx] + nextDist;
                    pq.add(new Info(dist[nextIdx], nextIdx));
                }
            }
        }

        return dist;
    }
}