//누적합???
import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static long sum[], count[];
    static long ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        sum = new long[N + 1];
        count = new long[M];

        for (int i = 1; i <= N; i++) {
            sum[i] = (sum[i - 1] + Integer.parseInt(st.nextToken())) % M;
            count[(int) sum[i]]++;
        }

        ans += count[0];

        for (int i = 0; i < M; i++) {
            if (count[i] > 1) {
                ans += (count[i] * (count[i] - 1)) / 2;
            }
        }

        System.out.println(ans);
    }
}
