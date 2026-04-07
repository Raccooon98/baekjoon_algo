import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];
        int[] pre = new int[N + 1];
        int ans = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        if (arr[1] != 1) {
            ans = 1;
            System.out.println(ans);
            return;
        }

        pre[1] = arr[1];

        int idx = 2;
        while (idx <= N) {
            if (arr[idx] > pre[idx - 1] + 1) {
                ans = pre[idx - 1] + 1;
                break;
            }

            pre[idx] = pre[idx - 1] + arr[idx];
            idx++;
        }

        ans = pre[idx - 1] + 1;

        System.out.println(ans);
    }
}
