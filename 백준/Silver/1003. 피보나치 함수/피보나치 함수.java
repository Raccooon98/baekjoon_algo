import java.io.*;
import java.util.*;

public class Main{
    static int N;
    static int[][] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        sum = new int[41][2];

        sum[0] = new int[]{1, 0};
        sum[1] = new int[]{0, 1};

        for (int i = 2; i <= 40; i++) {
            sum[i][0] = sum[i - 2][0] + sum[i - 1][0];
            sum[i][1] = sum[i - 2][1] + sum[i - 1][1];
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());

            sb.append(sum[num][0]).append(" ").append(sum[num][1]).append("\n");
        }

        System.out.println(sb.toString().trim());
    }
}
