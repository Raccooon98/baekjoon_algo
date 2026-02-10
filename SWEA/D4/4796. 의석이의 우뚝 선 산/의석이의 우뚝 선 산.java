import java.io.*;
import java.util.*;

public class Solution {
    static int[] arr;
    static int N;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int ans = 0;
            N = sc.nextInt();

            arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            for (int i = 1; i < N - 1; i++) {
                if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1])
                    ans += search(i);
            }

            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }

        System.out.print(sb.toString());
        sc.close();
    }

    static int search(int n) {
        int left = 0;
        int right = 0;

        int l = n;
        while (l > 0 && arr[l - 1] < arr[l]) {
            left++;
            l--;
        }

        int r = n;
        while (r < N - 1 && arr[r] > arr[r + 1]) {
            right++;
            r++;
        }

        return left*right;
    }
}
