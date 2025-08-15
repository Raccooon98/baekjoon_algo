//문제 형식이 DP로 예상됨 BFS도 될지도..?
//손으로 써본 결과 1개씩 증가하고 2,3의 배수일때 증가하는 갯수의 변동이 생김
import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static int dp[] = new int[10001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        solve();

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append("\n");
        }

        System.out.println(sb);
    }

    public static void solve() {
        dp[0] = 1; // 0을 만드는 방법은 1가지 (아무것도 더하지 않는 경우)
        
        for (int i = 1; i <= 10000; i++) {
            dp[i] = 1;
        }

        for (int i = 2; i <= 10000; i++) {
            dp[i] += dp[i - 2];
        }

        for (int i = 3; i <= 10000; i++) {
            dp[i] += dp[i - 3];
        }
    }
}
