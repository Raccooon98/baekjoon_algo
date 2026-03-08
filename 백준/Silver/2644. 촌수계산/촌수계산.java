import java.io.*;
import java.util.*;

public class Main{
    static int N, M, target, start;
    static ArrayList<Integer>[] node;
    static int ans = -1;
    static boolean[] vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        vis = new boolean[N + 1];
        node = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            node[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            node[a].add(b);
            node[b].add(a);
        }

        DFS(start, 0);

        System.out.println(ans);
    }

    static void DFS(int cur, int cnt) {
        if (cur == target) {
            ans = cnt;
            return;
        }

        for (int next : node[cur]) {
            if (!vis[next]) {
                vis[next] = true;
                DFS(next, cnt + 1);
            }
        }
    }
}
