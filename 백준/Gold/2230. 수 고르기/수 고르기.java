import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int ans = Integer.MAX_VALUE;
    static int arr[];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int right = 0;
        for (int left = 0; left < N; left++) {
            while (right < N && arr[right] - arr[left] < M)
                right++;
            if (right >= N) break;
            ans = Math.min(ans, arr[right] - arr[left]);
        }

        System.out.println(ans);
    }
}
