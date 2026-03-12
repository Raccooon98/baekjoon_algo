import java.io.*;
import java.util.*;

public class Solution {
    static int N, M, max = 0;
    static ArrayList<Integer>[] node;
    static int[] vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            max = 0;
            vis = new int[101];
            node = new ArrayList[101];
            for (int i = 1; i <= 100; i++) {
                node[i] = new ArrayList<>();
            }


            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N / 2; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                node[from].add(to);
            }

            BFS(M);
            int maxVis = 0;
            for (int n : vis) {
                maxVis = Math.max(maxVis, n);
            }
            for (int i = 100; i >= 1; i--) {
                if (vis[i] == maxVis) {
                    max = i;
                    break;
                }
            }

            sb.append("#").append(t).append(" ").append(max).append("\n");
        }
        System.out.println(sb.toString().trim());
    }

    static void BFS(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        vis[start] = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : node[cur]) {
                if (vis[next] != 0) continue;

                vis[next] = vis[cur] + 1;
                q.offer(next);
            }
        }
    }
}
