//IOI가 N번 연속으로 붙어있으면 카운트 하는 방식으로 진행
//슬라이딩 윈도우로 직접 문자열을 검사하면 망할것 같은 느낌
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        int count = 0;
        int ans = 0;
        for (int i = 1; i < M - 1; i++) {
            if (S.charAt(i - 1) == 'I' && S.charAt(i) == 'O' && S.charAt(i + 1) == 'I') {
                count++;
                if (count == N) {
                    ans++;
                    count--;
                }

                i++;
            } else {
                count = 0;
            }
        }

        System.out.println(ans);
    }
}
