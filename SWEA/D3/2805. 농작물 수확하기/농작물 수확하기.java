import java.io.*;
import java.util.*;

public class Solution {
    static int ans = 0;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            ans = 0;
            int N = Integer.parseInt(br.readLine());
            board = new int[N][N];

            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                for (int j = 0; j < N; j++) {
                    board[i][j] = s.charAt(j) - '0';
                }
            }

            int x = (N - 1) / 2;
            int y = (N - 1) / 2;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int dist = Math.abs(x - i) + Math.abs(y - j);
                    if (dist <= (N - 1) / 2) ans += board[i][j];
                }
            }

            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.println(sb.toString());
    }
}
