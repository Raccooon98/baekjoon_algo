import java.io.*;
import java.util.*;

public class Main {
    static int N, ans = 0;
    static int[] health, weight;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        health = new int[N];
        weight = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            health[i] = Integer.parseInt(st.nextToken());
            weight[i] = Integer.parseInt(st.nextToken());
        }

        DFS(0, 0);
        System.out.println(ans);
    }

    static void DFS(int depth, int cnt) {
        if (cnt == N - 1 || depth >= N) {
            ans = Math.max(cnt, ans);
            return;
        }

        if (health[depth] <= 0)
            DFS(depth + 1, cnt);
        else {
            for (int i = 0; i < N; i++) {
                if (i == depth) {
                    continue;
                }
                if (health[i] > 0) {
                    health[i] -= weight[depth];
                    health[depth] -= weight[i];
                    DFS(depth + 1, cnt + (health[i] <= 0 ? 1 : 0) + (health[depth] <= 0 ? 1 : 0));
                    health[i] += weight[depth];
                    health[depth] += weight[i];
                }
            }
        }
    }
}
