import java.util.*;
import java.io.*;

public class Main{
    static long ans = Long.MAX_VALUE;
    static int[][] ingredient;
    static boolean[] vis;
    static Stack<Integer> arr = new Stack<>();
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());

        ingredient = new int[N][2];
        vis = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            ingredient[i][0] = Integer.parseInt(st.nextToken());
            ingredient[i][1] = Integer.parseInt(st.nextToken());
        }

        DFS(0, 1L, 0L, false);

        System.out.println(ans);
    }

    static void DFS(int depth, long sour, long bitter, boolean check) {
        if (depth >= N) {
            if (check) {
                long diff = Math.abs(sour - bitter);
                ans = Math.min(ans, diff);
            }
            return;
        }

        DFS(depth + 1, sour * ingredient[depth][0], bitter + ingredient[depth][1], true);

        DFS(depth + 1, sour, bitter, check);
    }
}
