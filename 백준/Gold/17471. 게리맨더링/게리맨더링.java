import java.io.*;
import java.util.*;

public class Main{
    static int N, ans = Integer.MAX_VALUE;
    static int[] population;
    static boolean[][] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        population = new int[N + 1];
        adj = new boolean[N + 1][N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            population[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < num; j++) {
                int n = Integer.parseInt(st.nextToken());
                adj[i][n] = true;
                adj[n][i] = true;
            }
        }

        for (int i = 1; i <= N / 2; i++) {
            DFS(1, 0, i, new ArrayList<>());
        }

        if (ans == Integer.MAX_VALUE) {
            ans = -1;
        }

        System.out.println(ans);
    }

    static void DFS(int cur, int depth, int target, ArrayList<Integer> list) {
        if (depth == target) {
            gerrymandering(list);
            return;
        }

        for (int i = cur; i <= N; i++) {
            list.add(i);
            DFS(i + 1, depth + 1, target, list);
            list.remove(list.size() - 1);
        }
    }

    static void gerrymandering(ArrayList<Integer> list) {
        if (!connected(list)) return;

        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (list.contains(i)) continue;
            list2.add(i);
        }


        if (list2.isEmpty() || !connected(list2)) return;

        int sum1 = 0, sum2 = 0;
        for (int n : list) sum1 += population[n];
        for (int n : list2) sum2 += population[n];

        ans = Math.min(ans, Math.abs(sum1 - sum2));
    }

    static boolean connected(ArrayList<Integer> list) {
        if (list.isEmpty()) return false;

        boolean[] vis = new boolean[N + 1];
        Queue<Integer> q = new ArrayDeque<>();

        int start = list.get(0);
        q.offer(start);
        vis[start] = true;

        int cnt = 1;
        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int i = 1; i <= N; i++) {

                if (adj[cur][i] && list.contains(i) && !vis[i]) {
                    vis[i] = true;
                    q.offer(i);
                    cnt++;
                }
            }
        }

        return cnt == list.size();
    }
}