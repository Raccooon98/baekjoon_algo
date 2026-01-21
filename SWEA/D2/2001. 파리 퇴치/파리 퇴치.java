import java.io.*;
import java.util.*;

public class Solution {
    private static int[][] input, presum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            input = new int[N + 1][N + 1];
            presum = new int[N + 1][N + 1];

            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++) {
                    input[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    presum[i][j] = presum[i - 1][j] + presum[i][j - 1] + input[i][j] - presum[i - 1][j - 1];
                }
            }

            int max = 0;

            for (int i = 1; i <= N - M + 1; i++) {
                for (int j = 1; j <= N - M + 1; j++) {
                    int sum = presum[i + M - 1][j + M - 1] - presum[i - 1][j + M - 1] - presum[i + M - 1][j - 1] + presum[i - 1][j - 1];
                    max = Math.max(sum, max);
                }
            }

            sb.append("#").append(t).append(" ").append(max).append("\n");
        }

        System.out.println(sb.toString());
    }
}
