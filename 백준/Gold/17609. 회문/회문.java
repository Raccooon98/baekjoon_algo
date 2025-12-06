import java.io.*;
import java.util.*;

public class Main {
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String str = br.readLine();
            sb.append(checkPal(str)).append("\n");
        }

        System.out.println(sb);
    }

    static int checkPal(String s) {
        int l = 0, r = s.length() - 1;

        while (l <= r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                if (isPal(s, l + 1, r) || isPal(s, l, r - 1)) {
                    return 1;
                }
                return 2;
            }
        }
        return 0;
    }

    static boolean isPal(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return false;

            l++;
            r--;
        }
        return true;
    }
}
