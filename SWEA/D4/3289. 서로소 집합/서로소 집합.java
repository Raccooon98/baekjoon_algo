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
            sb.append("#").append(t).append(" ");
            parent = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                parent[i] = i;
            }


            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int command = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (command == 0) {
                    union(a, b);
                } else if (command == 1) {
                    if (findParent(a) == findParent(b)) {
                        sb.append(1);
                    } else {
                        sb.append(0);
                    }
                }
            }
            sb.append("\n");
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
