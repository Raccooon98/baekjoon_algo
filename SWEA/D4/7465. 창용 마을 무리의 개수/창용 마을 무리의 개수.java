import java.io.*;
import java.util.*;

public class Solution {
    static int N, M;
    static int[] parent;

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

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                union(a, b);
            }

            Set<Integer> set = new HashSet<>();
            for (int i = 1; i <= N; i++) {
                set.add(findParent(i));
            }

            sb.append("#").append(t).append(" ").append(set.size()).append("\n");
        }
        System.out.println(sb.toString().trim());
    }

    static void union(int a, int b) {
        int pa = findParent(a);
        int pb = findParent(b);
        parent[pb] = pa;
    }

    static int findParent(int n) {
        if (parent[n] == n) return n;
        return parent[n] = findParent(parent[n]);
    }
}
