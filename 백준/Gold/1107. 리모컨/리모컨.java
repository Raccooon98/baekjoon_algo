import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean[] broken = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        if (M > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                broken[Integer.parseInt(st.nextToken())] = true;
            }
        }

        int minCount = Math.abs(N - 100);

        for (int i = 0; i <= 1000000; i++) {
            int len = check(i);
            if (len > 0) {
                int press = Math.abs(N - i) + len;
                minCount = Math.min(minCount, press);
            }
        }

        System.out.println(minCount);
    }

    public static int check(int num) {
        if (num == 0) {
            return broken[0] ? 0 : 1;
        }

        int len = 0;
        int temp = num;
        while (temp > 0) {
            if (broken[temp % 10]) {
                return 0; // 고장난 버튼이 포함되어 있으면 만들 수 없음
            }
            len++;
            temp /= 10;
        }
        return len;
    }
}
