//결국 이분탐색 결정문제
//답이 될 수 있는 값을 이분탐색으로 찾기
//각 블루레이에 넣을 수 있는지는 그리디하게 판단해보기
import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int lecture[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lecture = new int[N];
        st = new StringTokenizer(br.readLine());

        int left = 0;
        int right = 0;
        for (int i = 0; i < N; i++) {
            lecture[i] = Integer.parseInt(st.nextToken());
            left = Math.max(left, lecture[i]);
            right += lecture[i];
        }


        int ans = right;
        while (left <= right) {
            int mid = (left + right) / 2;
            int sum = 0, count = 1;

            for (int i = 0; i < N; i++) {
                if (sum + lecture[i] > mid) {
                    count++;
                    sum = 0;
                }
                sum += lecture[i];
            }

            if (count > M) left = mid + 1;
            else {
                ans = mid;
                right = mid - 1;
            }
        }

        System.out.println(left);
    }
}
