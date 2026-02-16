import java.io.*;
import java.util.*;

public class Solution {
    static long N, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());

        for (int t = 1; t <= T; t++) {
            ans = Long.MAX_VALUE;
            N = Long.parseLong(br.readLine());
            int cnt = 0;

            while (N > 2) {
                long temp = (long) Math.sqrt(N);

                if (temp * temp == N) {
                    N = temp;
                    cnt++;
                } else {
                    long next = (temp + 1) * (temp + 1);
                    cnt += (next - N);
                    N = next;
                }
            }

            sb.append("#").append(t).append(" ").append(cnt).append("\n");
        }

        System.out.println(sb.toString());
    }
}