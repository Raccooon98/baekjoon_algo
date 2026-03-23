import java.io.*;
import java.util.*;

public class Solution {
    static int N, M;
    static int[] parent, rank;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            parent = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                parent[i] = i;
            }

            st = new StringTokenizer(br.readLine());

            for (int m = 0; m < M; m++) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                union(a, b);
            }

            Set<Integer> set = new HashSet<>();
            for (int i = 1; i <= N; i++) {
                set.add(find(i));
            }

            sb.append("#").append(t).append(" ").append(set.size()).append("\n");
        }

        System.out.println(sb.toString().trim());
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) parent[rootB] = rootA;
    }

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}
