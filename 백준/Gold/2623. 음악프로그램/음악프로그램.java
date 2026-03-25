import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] indegree = new int[N + 1];
        ArrayList<Integer>[] adj = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());

            if (count <= 1) continue;

            int prev = Integer.parseInt(st.nextToken());
            for (int j = 0; j < count - 1; j++) {
                int curr = Integer.parseInt(st.nextToken());
                adj[prev].add(curr);
                indegree[curr]++;
                prev = curr;
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        while (!q.isEmpty()) {
            int cur = q.poll();
            result.add(cur);

            for (int next : adj[cur]) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }
        
        if (result.size() != N) {
            System.out.println(0);
        } else {
            for (int node : result) {
                sb.append(node).append("\n");
            }
            System.out.print(sb);
        }
    }
}
