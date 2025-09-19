import java.io.*;
import java.util.*;

public class Main {
    static int V;
    static ArrayList<Node> tree[];
    static int maxDist, farNode;
    static boolean vis[];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        StringTokenizer st;

        tree = new ArrayList[V + 1];
        for (int i = 0; i <= V; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());

            while (true) {
                int to = Integer.parseInt(st.nextToken());
                if (to == -1)
                    break;
                int dist = Integer.parseInt(st.nextToken());

                tree[from].add(new Node(to, dist));
                tree[to].add(new Node(from, dist));
            }
        }

        vis = new boolean[V + 1];
        maxDist = 0;
        DFS(1, 0);

        vis = new boolean[V + 1];
        maxDist = 0;
        DFS(farNode, 0);

        System.out.println(maxDist);
    }

    private static void DFS(int cur, int dist) {
        vis[cur] = true;

        if (dist > maxDist) {
            maxDist = dist;
            farNode = cur;
        }

        for (Node next : tree[cur]) {
            if (!vis[next.to])
                DFS(next.to, dist + next.dist);
        }
    }

    private static class Node {
        int to, dist;

        public Node(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }
    }
}
