import java.io.*;
import java.util.*;

public class Main {
    static boolean[] isPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        isPrime = new boolean[250001];

        for (int i = 0; i < isPrime.length; i++) {
            isPrime[i] = true;
        }

        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i <= Math.sqrt(250000); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= 250000; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            int count = 0;
            for (int i = n + 1; i <= 2 * n; i++) {
                if (isPrime[i]) count++;
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb.toString());
    }
}
