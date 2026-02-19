import java.io.*;
import java.util.*;

public class Solution {
    static int ans, N;
    static int[] arr;
    static boolean[] vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            ans = 0;
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            nqueen(0);

            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }

        System.out.println(sb.toString());
    }

    static void nqueen(int depth) {
        if (depth >= N) {
            ans++;
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[depth] = i;
            if (isPossible(depth)) {
                nqueen(depth + 1);
            }
        }
    }

    static boolean isPossible(int col) {
        for (int i = 0; i < col; i++) {
            if (arr[col] == arr[i]) {
                return false;
            }

            if (Math.abs(i - col) == Math.abs(arr[i] - arr[col])) {
                return false;
            }
        }

        return true;
    }
}
