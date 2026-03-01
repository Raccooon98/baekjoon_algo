import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, K, count = 0, min = Integer.MAX_VALUE;
    static int[] vis = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
            System.out.println(1);
        } else if (N > K) {
            System.out.println(N - K);
            System.out.println(1);
        } else {
            BFS();
            sb.append(min).append("\n").append(count);
            System.out.println(sb.toString());
        }
    }

    static void BFS() {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(N);
        vis[N] = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (min < vis[cur]) continue;

            for (int i = 0; i < 3; i++) {
                int next = 0;
                if (i == 0) {
                    next = cur + 1;
                } else if (i == 1) {
                    next = cur - 1;
                } else if (i == 2) {
                    next = cur * 2;
                }

                if (next < 0 || next >= 100001) continue;
                if (next == K) {
                    if (vis[cur] >= min) {
                        count++;
                    } else {
                        min = vis[cur];
                        count = 1;
                    }
                } else if (vis[next] == 0 || vis[next] >= vis[cur] + 1) {
                    q.offer(next);
                    vis[next] = vis[cur] + 1;
                }
            }
        }
    }
}
