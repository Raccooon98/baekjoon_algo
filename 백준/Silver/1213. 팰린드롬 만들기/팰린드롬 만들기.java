//문자열에 홀수개인 문자가 2가지 이상 있으면 팰린드롬이 성립할 수 없다.
import java.io.*;
import java.util.*;

public class Main {
    static int[] arr = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        StringBuilder sb = new StringBuilder();

        int odd = 0, num = 0;
        int len = S.length();

        for (char c : S.toCharArray()) {
            int idx = c - 'A';
            arr[idx]++;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                odd++;
                num = i;
            }
            if (odd >= 2) {
                System.out.println("I'm Sorry Hansoo");
                return;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i] / 2; j++) {
                sb.append((char) (i + 'A'));
            }
        }
        String ans = sb.toString();
        if (odd == 1) {
            ans += (char) (num + 'A');
        }

        ans += sb.reverse().toString();
        System.out.println(ans);
    }
}
