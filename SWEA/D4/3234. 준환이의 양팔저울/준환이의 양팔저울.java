//경우의 수를 만드는 과정에서도 오른쪽이 더 무거우면 안됨

import java.io.*;
import java.util.*;

public class Solution {
    static int[] arr;
    static boolean[] vis;
    static int ans, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());

        for (int t = 1; t <= T; t++) {
            ans = 0;
            N = Integer.parseInt(br.readLine());
            arr = new int[N];

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            vis = new boolean[N];

            DFS(0, 0, 0);

            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }

        System.out.println(sb.toString());
    }

    static void DFS(int depth, int left, int right) {
        if (depth >= N) {
            ans++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!vis[i]) {
                vis[i] = true;

                DFS(depth + 1, left + arr[i], right);

                if (right + arr[i] <= left) {
                    DFS(depth + 1, left, right + arr[i]);
                }

                vis[i] = false;
            }

        }

    }
}
