import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력부터 다 처리해놓고 고민할래~
        String strSequence1 = br.readLine();
        String strSequence2 = br.readLine();
        int len1 = strSequence1.length();
        int len2 = strSequence2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 1; i <= len1; i ++) {
            for (int j = 1; j <= len2; j ++) {
                if (strSequence1.charAt(i - 1) == strSequence2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[len1][len2]);
    }
}