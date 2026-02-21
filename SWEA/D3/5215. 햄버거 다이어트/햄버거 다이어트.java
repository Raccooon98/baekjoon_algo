import java.io.*;
import java.util.*;

public class Solution {
    static int N, L, max;
    static int[] score, weight;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            max = 0;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            score = new int[N];
            weight = new int[N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int k = Integer.parseInt(st.nextToken());

                score[i] = s;
                weight[i] = k;
            }

            DFS(0, 0, 0);
            sb.append("#").append(t).append(" ").append(max).append("\n");
        }
        System.out.println(sb.toString());
    }

    static void DFS(int sum, int depth, int weights) {
        if (depth >= N) {
            max = Math.max(sum, max);
            return;
        }

        if (weights + weight[depth] > L) {
            DFS(sum, depth + 1, weights);
        } else {
            DFS(sum, depth + 1, weights);
            DFS(sum + score[depth], depth + 1, weights + weight[depth]);
        }
    }
}
