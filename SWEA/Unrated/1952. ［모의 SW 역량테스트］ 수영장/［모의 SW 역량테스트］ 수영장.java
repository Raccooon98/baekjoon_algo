import java.util.*;
import java.io.*;

public class Solution {
    static int[] fee;
    static int[] plan;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());

        for (int t = 1; t <= T; t++) {
            fee = new int[4];
            plan = new int[12];
            min = Integer.MAX_VALUE;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                fee[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 12; i++) {
                plan[i] = Integer.parseInt(st.nextToken());
            }

            func(0, 0);

            sb.append("#").append(t).append(" ").append(min).append("\n");
        }
        System.out.println(sb.toString());
    }

    static void func(int sum, int depth) {
        if (depth >= 12) {
            min = Math.min(sum, min);
            return;
        }

        func(sum + (plan[depth] * fee[0]), depth + 1);
        func(sum + fee[1], depth + 1);
        func(sum + fee[2], depth + 3);
        func(sum + fee[3], depth + 12);
    }
}
