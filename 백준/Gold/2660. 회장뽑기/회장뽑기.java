import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<Integer> adj[];
    static int friends[];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        friends = new int[N + 1];
        adj = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1) {
                break;
            }

            adj[a].add(b);
            adj[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            BFS(i);
        }

        int min = Integer.MAX_VALUE;
        for(int i=1;i<=N;i++){
            if(friends[i]==0) continue;
            min = Math.min(min,friends[i]);
        }

        List<Integer> ans =new ArrayList<>();
        int count=0;
        for(int i=1;i<=N;i++){
            if(friends[i]==min){
                count++;
                ans.add(i);
            }
        }
        sb.append(min).append(" ").append(count).append("\n");
        for(int num:ans){
            sb.append(num).append(" ");
        }

        System.out.println(sb);
    }

    private static void BFS(int cur) {
        int[] vis = new int[N + 1];
        Arrays.fill(vis, -1);
        Queue<Integer> q = new ArrayDeque<>();

        q.add(cur);
        vis[cur] = 0;

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int next : adj[now]) {
                if (vis[next] == -1) {
                    vis[next] = vis[now] + 1;
                    q.add(next);
                }
            }
        }

        boolean allVisited = true;
        int maxDist = 0;
        for (int i = 1; i <= N; i++) {
            if (vis[i] == -1) {
                allVisited = false;
                break;
            }
            maxDist = Math.max(maxDist, vis[i]);
        }

        if (allVisited) {
            friends[cur] = maxDist;
        }
    }
}
