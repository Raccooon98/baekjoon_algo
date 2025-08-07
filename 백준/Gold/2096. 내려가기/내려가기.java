// 완탐으로 해보려했는데 N이 10만이라서 시간초과날듯X -> 문제 잘못 이해(N x N 이 아니라 N x 3이었음)
// 그러면 DP일 확률이 높다
import java.io.*;
import java.util.*;

public class Main {
    static int Board[][];
    static int dp[][];
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        Board = new int[N + 1][3];
        dp = new int[N + 1][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                Board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 3; i++) {
            dp[0][i] = Board[0][i];
        }

        int left = 0;
        int right = 0;
        //최대값
        for(int i=1;i<N;i++){
            left = Math.max(dp[i-1][0],dp[i-1][1]);
            right = Math.max(dp[i-1][1],dp[i-1][2]);

            dp[i][0] = Board[i][0] + left;
            dp[i][1] = Board[i][1] + Math.max(left,right);
            dp[i][2] = Board[i][2] + right;
        }
        sb.append(Math.max(dp[N-1][0],Math.max(dp[N-1][1],dp[N-1][2]))+" ");
        //최소값
        for(int i=1;i<N;i++){
            left = Math.min(dp[i-1][0],dp[i-1][1]);
            right = Math.min(dp[i-1][1],dp[i-1][2]);

            dp[i][0] = Board[i][0] + left;
            dp[i][1] = Board[i][1] + Math.min(left,right);
            dp[i][2] = Board[i][2] + right;
        }

        sb.append(Math.min(dp[N-1][0],Math.min(dp[N-1][1],dp[N-1][2])));

        System.out.println(sb);
    }
}
