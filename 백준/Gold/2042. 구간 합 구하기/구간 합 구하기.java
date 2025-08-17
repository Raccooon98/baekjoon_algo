import java.io.*;
import java.util.*;

public class Main {
    static long tree[];
    static int N, M, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int h = (int) Math.ceil(Math.log(N) / Math.log(2));
        int treesize = (1 << (h + 1));
        tree = new long[treesize];

        for (int i = 0; i < N; i++) {
            long num = Long.parseLong(br.readLine());
            update(1, 0, N - 1, i, num);
        }

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                long diff = c - sum(1, 0, N - 1, b - 1, b - 1);
                update(1, 0, N - 1, b - 1, diff);
            } else {
                long sum = sum(1, 0, N - 1, b - 1, (int) c - 1);
                sb.append(sum).append("\n");
            }
        }
        System.out.println(sb);

    }

    private static void update(int node, int start, int end, int index, long diff) {
        if (index < start || index > end) return;
        tree[node] += diff;

        if (start != end) {
            int mid = (start + end) / 2;
            update(node * 2, start, mid, index, diff);
            update(node * 2 + 1, mid + 1, end, index, diff);
        }
    }

    private static long sum(int node, int start, int end, int left, int right) {
        if (left > end || right < start) return 0;
        if (left <= start && end <= right) return tree[node];

        int mid = (start + end) / 2;
        return sum(node * 2, start, mid, left, right) + sum(node * 2 + 1, mid + 1, end, left, right);
    }
}
