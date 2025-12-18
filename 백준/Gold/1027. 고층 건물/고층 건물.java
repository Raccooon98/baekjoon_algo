import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans = Math.max(ans, Count(i));
        }

        System.out.println(ans);
    }

    private static int Count(int n) {
        int cnt = 0;
        double lean = 0;

        for (int i = n - 1; i >= 0; i--) {
            double slope = (double) (arr[n] - arr[i]) / (n - i);

            if (i == n - 1 || lean > slope) {
                cnt++;
                lean = slope;
            }
        }

        for (int i = n + 1; i < N; i++) {
            double slope = (double) (arr[n] - arr[i]) / (n - i);

            if (i == n + 1 || lean < slope) {
                cnt++;
                lean = slope;
            }
        }

        return cnt;
    }
}
