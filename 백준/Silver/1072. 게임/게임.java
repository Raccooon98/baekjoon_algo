//이분탐색으로 현재 승률보다 1이 높게 나오는 추가 판수 중 최소값 구하기
import java.io.*;
import java.util.*;

public class Main {
    static long X, Y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Long.parseLong(st.nextToken());
        Y = Long.parseLong(st.nextToken());

        long left = 1, right = 1_000_000_000L;
        long mingame = Long.MAX_VALUE;
        long cur_rate = (Y * 100) / X;

        if (X == Y) {
            System.out.println(-1);
            System.exit(0);
        }else if(cur_rate==99){
            System.out.println(-1);
            System.exit(0);
        }

        while (left <= right) {

            long mid = (right + left) / 2;
            long new_rate = ((Y + mid) * 100) / (X + mid);

            if (new_rate - cur_rate >= 1) {
                right = mid - 1;
                mingame = mid;
            } else
                left = mid + 1;
        }

        System.out.println(mingame);
    }
}
