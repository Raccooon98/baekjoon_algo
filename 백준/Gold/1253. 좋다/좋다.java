import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int arr[];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int ans = 0;
        for (int i = 0; i < N; i++) {
            int cur = arr[i];
            int left = 0, right = N - 1;
            boolean isGood = false;
            while (left < right) {
                int sum = arr[left] + arr[right];
                if (sum == cur) {
                    if (left != i && right != i) {
                        ans++;
                        break;
                    } else if (left == i) left++;
                    else if (right == i) right--;
                }
                else if (sum < cur) left++;
                else right--;
            }
        }
        System.out.println(ans);
    }
}
