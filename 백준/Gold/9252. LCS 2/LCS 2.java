import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] S1 = br.readLine().trim().toCharArray();
        char[] S2 = br.readLine().trim().toCharArray();
        int[][] lcs = new int[S1.length + 1][S2.length + 1];

        for (int i = 1; i <= S1.length; i++) {
            for (int j = 1; j <= S2.length; j++) {
                if (S1[i - 1] == S2[j - 1]) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                } else if (lcs[i][j - 1] < lcs[i - 1][j]) {
                    lcs[i][j] = lcs[i - 1][j];
                } else {
                    lcs[i][j] = lcs[i][j - 1];
                }
            }
        }

        int s1 = S1.length;
        int s2 = S2.length;

        while (0 < lcs[s1][s2]) {
            if (lcs[s1][s2] == lcs[s1][s2 - 1]) {
                s2--;
            } else if (lcs[s1][s2] == lcs[s1 - 1][s2]) {
                s1--;
            } else {
                sb.append(S1[--s1]);
                s2--;
            }
        }
        System.out.println(lcs[S1.length][S2.length]);
        System.out.println(sb.reverse());
    }
}
