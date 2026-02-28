import java.io.*;
import java.util.*;

public class Main {
    static int N, M, V;
    static ArrayList<Integer>[] adj;
    static StringBuilder sb;
    static boolean[] vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        for (int i = 0; i <= N; i++) {
            Collections.sort(adj[i]);
        }
        vis = new boolean[N + 1];
        DFS(V);
        sb.append("\n");
        vis = new boolean[N + 1];
        BFS();

        System.out.println(sb.toString());
    }

    static void DFS(int cur) {
        vis[cur] = true;
        sb.append(cur).append(" ");

        for (int next : adj[cur]) {
            if (vis[next]) continue;
            DFS(next);
        }
    }

    static void BFS() {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(V);
        vis[V] = true;
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append(" ");

            for (int next : adj[cur]) {
                if (vis[next]) continue;

                q.offer(next);
                vis[next] = true;
            }
        }
    }
}
