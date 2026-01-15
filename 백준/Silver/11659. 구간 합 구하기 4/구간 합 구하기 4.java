import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        long[] prefix = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        prefix[0] = arr[0];
        for (int i = 1; i < N; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        for (int m = 0; m < M; m++) {
            long sum = 0;
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken()) - 1;
            int j = Integer.parseInt(st.nextToken()) - 1;

            if (i == 0) {
                sum = prefix[j];
            }else {
                sum = prefix[j]-prefix[i-1];
            }

            sb.append(sum).append("\n");
        }


        System.out.println(sb.toString());
    }
}
