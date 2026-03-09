import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean found;
    static ArrayList<Integer>[] list;
    static boolean[] vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N];
        vis = new boolean[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        for (int i = 0; i < N; i++) {
            dfs(i, 0);
            if (found) break;
        }

        System.out.println(found ? 1 : 0);
    }

    static void dfs(int cur, int depth) {
        if (depth == 4) {
            found = true;
            return;
        }

        vis[cur] = true;
        for (int next : list[cur]) {
            if (!vis[next]) {
                dfs(next, depth + 1);
            }
            if (found) return;
        }
        vis[cur] = false;
    }
}
