//에라토스테네스만 알면 어려울건 없는 문제인듯
import java.io.*;
import java.util.*;

public class Main {
    static final int MAX_VAL = 1299709;
    static int T;
    static boolean[] isPrime = new boolean[MAX_VAL + 1];

    public static void main(String args[]) throws IOException {
        for (int i = 0; i <= MAX_VAL; i++) {
            isPrime[i] = true;
        }
        isPrime[0] = false;
        isPrime[1] = false;

        for (int p = 2; p * p <= MAX_VAL; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= MAX_VAL; i += p) {
                    isPrime[i] = false;
                }
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int k = Integer.parseInt(br.readLine());

            if (isPrime[k]) {
                System.out.println(0);
                continue;
            }

            int num1 = 0;
            //k보다 작은 가장 큰 소수
            for (int i = k - 1; i >= 2; i--) {
                if (isPrime[i]) {
                    num1 = i;
                    break;
                }
            }

            int num2 = 0;
            for (int i = k + 1; i <= MAX_VAL; i++) {
                if (isPrime[i]) {
                    num2 = i;
                    break;
                }
            }

            System.out.println(num2 - num1);
        }
    }
}
