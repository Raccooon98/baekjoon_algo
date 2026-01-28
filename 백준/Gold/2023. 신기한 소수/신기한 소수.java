import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        DFS(0, N);

        System.out.println(sb.toString());
    }

    static boolean isPrime(int x) {
        if (x < 2) return false;
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) return false;
        }
        return true;
    }

    static void DFS(int n, int depth) {
        if (depth == 0) {
            sb.append(n).append("\n");
            return;
        }

        for (int i = 1; i <= 9; i++) {
            int temp = 10 * n + i;
            if (isPrime(temp)) {
                DFS(temp, depth - 1);
            }
        }
    }
}
