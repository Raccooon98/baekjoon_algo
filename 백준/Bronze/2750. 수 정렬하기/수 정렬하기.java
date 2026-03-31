import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            arr[i] = n;
        }

        Arrays.sort(arr);

        for (int n : arr) {
            sb.append(n).append("\n");
        }

        System.out.println(sb.toString());
    }
}
