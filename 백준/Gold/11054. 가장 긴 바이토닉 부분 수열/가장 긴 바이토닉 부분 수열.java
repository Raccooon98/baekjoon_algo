import java.io.*;
import java.util.*;

public class Main{
    static int[] arr;
    static Integer[] left_dp, right_dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        arr=new int[N];
        left_dp = new Integer[N];
        right_dp = new Integer[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            left(i);
            right(i);
        }

        int max = -1;
        for (int i = 0; i < N; i++) {
            max=Math.max(max,right_dp[i]+left_dp[i]-1);
        }

        System.out.println(max);
    }

    static int left(int depth) {

        if (left_dp[depth] == null) {
            left_dp[depth] = 1;

            for (int i = depth + 1; i < left_dp.length; i++) {
                if (arr[i] < arr[depth]) {
                    left_dp[depth] = Math.max(left_dp[depth], left(i) + 1);
                }
            }
        }

        return left_dp[depth];
    }

    static int right(int depth) {

        if (right_dp[depth] == null) {
            right_dp[depth] = 1;

            for (int i = depth - 1; i >= 0; i--) {
                if (arr[i] < arr[depth]) {
                    right_dp[depth] = Math.max(right_dp[depth], right(i) + 1);
                }
            }
        }
        return right_dp[depth];
    }
}
