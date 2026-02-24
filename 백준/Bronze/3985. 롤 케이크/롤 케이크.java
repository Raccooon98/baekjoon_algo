import java.io.*;
import java.util.*;

public class Main {
    static int L, N;
    static int[] P, K, cake, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        cake = new int[L + 1];

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        P = new int[N + 1];
        K = new int[N + 1];
        count = new int[N + 1];

        int tempmax = 0;
        int tempidx = 0;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            P[i] = Integer.parseInt(st.nextToken());
            K[i] = Integer.parseInt(st.nextToken());
            for (int j = P[i]; j <= K[i]; j++) {
                if (cake[j] == 0) cake[j] = i;
            }
            int diff = K[i] - P[i] + 1;
            if (diff > tempmax) {
                tempmax = Math.max(diff, tempmax);
                tempidx = i;
            }
        }

        for (int n : cake) {
            count[n]++;
        }

        int maxidx = 0;
        int realmax = 0;
        for (int i = 1; i <= N; i++) {
            if (count[i] > realmax) {
                maxidx = i;
                realmax = Math.max(realmax, count[i]);
            }
        }


        System.out.println(tempidx + "\n" + maxidx);
    }
}
