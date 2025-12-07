import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String A = br.readLine();
        String B = br.readLine();

        int alen = A.length();
        int blen = B.length();

        int[][] dp = new int[blen+1][alen+1];

        int max = dp[0][0];

        for (int i = 1; i <= blen; i++) {
            for (int j = 1; j <= alen; j++) {
                if (B.charAt(i-1) == A.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                }

            }
        }

        System.out.println(max);
    }
}
