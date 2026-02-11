import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int max = -1;
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int[] arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                max = Math.max(arr[i], max);
            }

            int even = 0;
            int odd = 0;

            for (int i = 0; i < N; i++) {
                arr[i] = max - arr[i];

                if (arr[i] == 0) continue;

                even += arr[i] / 2;
                odd += arr[i] % 2;
            }

            while (even > odd) {
                if (Math.abs(even - odd) == 1) break;

                even--;
                odd += 2;
            }

            int result = 0;

            if (even > odd) {
                result = even * 2;
            } else if (odd > even)
                result = odd * 2 - 1;
            else {
                result = even + odd;
            }

            sb.append("#").append(t).append(" ").append(result).append("\n");
        }
        System.out.println(sb.toString());
    }
}
