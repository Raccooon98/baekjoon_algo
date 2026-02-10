import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 0; i < Math.min(N, M) / 2; i++) {
            Deque<Integer> dq = new ArrayDeque<>();
            for (int j = i; j < M - i; j++) dq.add(arr[i][j]);
            for (int j = i + 1; j < N - i; j++) dq.add(arr[j][M - 1 - i]);
            for (int j = M - 2 - i; j >= i; j--) dq.add(arr[N - 1 - i][j]);
            for (int j = N - 2 - i; j > i; j--) dq.add(arr[j][i]);

            int count = R % dq.size();
            for (int r = 0; r < count; r++) {
                dq.addLast(dq.pollFirst());
            }

            for (int j = i; j < M - i; j++) arr[i][j] = dq.pollFirst();
            for (int j = i + 1; j < N - i; j++) arr[j][M - 1 - i] = dq.pollFirst();
            for (int j = M - 2 - i; j >= i; j--) arr[N - 1 - i][j] = dq.pollFirst();
            for (int j = N - 2 - i; j > i; j--) arr[j][i] = dq.pollFirst();
        }

        for (int[] row : arr) {
            for (int n : row) sb.append(n).append(" ");
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }
}
