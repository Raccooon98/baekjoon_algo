import java.io.*;
import java.util.*;

public class Main {
    static String A, B;
    static int alen, blen;
    static int[][] dp;
    static int max;
    static char[] s1, s2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();

        A = br.readLine();
        B = br.readLine();
        s1 = A.toCharArray();
        s2 = B.toCharArray();
        alen = A.length();
        blen = B.length();

        dp = new int[alen + 1][blen + 1];

        max = dp[0][0];

        for (int i = 1; i <= alen; i++) {
            for (int j = 1; j <= blen; j++) {
                if (s1[i - 1] == s2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else if (dp[i][j - 1] < dp[i - 1][j]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        int a = s1.length;
        int b = s2.length;
        while (0 < dp[a][b]) {
            if(dp[a][b] == dp[a][b-1]){
                b--;
            }else if(dp[a][b] == dp[a-1][b]){
                a--;
            }else{
                sb.append(s1[--a]);
                b--;
            }
        }

        System.out.println(dp[alen][blen]);
        System.out.println(sb.reverse().toString());
    }
}
