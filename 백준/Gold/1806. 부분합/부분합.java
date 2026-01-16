import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];
        int[] prefix = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        int left = 1;
        int right = 1;

        int min = Integer.MAX_VALUE;
        while (right <= N) {
            int diff = prefix[right] - prefix[left-1];

            if (diff < S) {
                if (right == N) break;
                right++;
            } else {
                min = Math.min(min, right - left+1);
                left++;
            }
        }
        
        System.out.println(min == Integer.MAX_VALUE ? 0 : min);
    }
}
