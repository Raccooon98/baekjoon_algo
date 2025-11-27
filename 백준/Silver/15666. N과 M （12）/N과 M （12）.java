import java.util.*;
import java.io.*;


public class Main {
    static int[] input, arr;
    static int N, M;
    static boolean[] vis;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        vis = new boolean[N];
        input = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);

        DFS(0, 0);

        System.out.println(sb.toString());
    }

    static void DFS(int depth, int cur) {
        if (depth == M) {
            for (int n : arr) {
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }

        int temp = -1;
        for (int i = cur; i < N; i++) {
            int now = input[i];
            if (temp == now) continue;
            else {
                temp = now;
                arr[depth] = now;
                DFS(depth + 1, i);
            }
        }
    }
}
