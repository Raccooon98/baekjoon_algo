import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[][] dp;
    static Bag[] bags;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bags = new Bag[N + 1];
        dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            bags[i] = new Bag(w, v);
        }

        for (int i = 1; i <= K; i++) {
            for (int j = 1; j <= N; j++) {

                dp[j][i] = dp[j - 1][i];

                if (i - bags[j].w >= 0) {
                    dp[j][i] = Math.max(dp[j - 1][i], bags[j].v + dp[j - 1][i - bags[j].w]);
                }
            }
        }

        System.out.println(dp[N][K]);
    }

    private static class Bag {
        int w, v;

        public Bag(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }
}
