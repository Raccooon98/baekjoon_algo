import java.util.*;
import java.io.*;

public class Solution {
    static int N, ans, min, max;
    static int[] operator;
    static int[] inputs;
    static int[] vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            vis = new int[4];
            operator = new int[4];
            N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                operator[i] = Integer.parseInt(st.nextToken());
            }

            inputs = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                inputs[i] = Integer.parseInt(st.nextToken());
            }

            DFS(0, inputs[0]);
            int ans = max - min;

            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }

        System.out.println(sb.toString());
    }

    static void DFS(int depth, int num) {
        if (depth == N-1) {
            max = Math.max(max,num);
            min = Math.min(min,num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (vis[i] >= operator[i]) continue;
            vis[i]++;
            if (i == 0)
                DFS(depth + 1, num + inputs[depth + 1]);
            else if (i == 1)
                DFS(depth + 1, num - inputs[depth + 1]);
            else if (i == 2)
                DFS(depth + 1, num * inputs[depth + 1]);
            else if (i == 3)
                DFS(depth + 1, num / inputs[depth + 1]);
            vis[i]--;
        }
    }
}
