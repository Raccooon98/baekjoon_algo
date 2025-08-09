//소수면 에라토스테네스의 채?
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int N, M;
    static boolean prime[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        prime = new boolean[M + 1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false; //0, 1은 소수가 아님

        for (int i = 2; i * i <= M; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= M; j+=i) {
                    prime[j] = false;
                }
            }
        }

        for (int i =N;i<=M;i++){
            if(prime[i])
                System.out.println(i);
        }

    }
}
