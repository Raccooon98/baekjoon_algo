import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int arr[];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        int left = 0, right = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            left = Math.max(left, arr[i]);
            right += arr[i];
        }

        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int sum = 0;
            int count = 1;

            for (int i = 0; i < N; i++) {
                if (sum + arr[i] > mid) {
                    count++;
                    sum = 0;
                }
                sum += arr[i];
            }

            if (count > M)
                left = mid + 1;
            else {
                ans = mid;
                right = mid - 1;
            }
        }

        System.out.println(ans);
    }
}
