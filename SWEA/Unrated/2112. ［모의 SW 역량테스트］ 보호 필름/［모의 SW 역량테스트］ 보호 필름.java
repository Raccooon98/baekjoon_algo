import java.io.*;
import java.util.*;

public class Solution {
    static int D, W, K, ans;
    static int[][] film;
    static int[][] temp;
    static int[] choose;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            ans = 0;
            st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            film = new int[D][W];

            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    film[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // K가 1이면 무조건 통과
            if (K == 1) {
                sb.append("#").append(t).append(" 0\n");
                continue;
            }

            ans = K; // 최악의 경우 K번 주입하면 무조건 통과 가능
            DFS(0, 0);
            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }

        System.out.println(sb.toString());
    }

    //특수 용액을 주입하면서 경우의 수 찾기
    static void DFS(int row, int count) {
        // 현재 주입 횟수가 이미 찾은 최소값보다 크면 종료
        if (count >= ans) return;

        // 모든 행을 다 결정했을 때 검사
        if (row == D) {
            if (canTest()) {
                ans = Math.min(ans, count);
            }
            return;
        }

        DFS(row + 1, count);

        int[] backup = film[row].clone();

        //A 주입
        Arrays.fill(film[row], 0);
        DFS(row + 1, count + 1);

        //B 주입
        Arrays.fill(film[row], 1);
        DFS(row + 1, count + 1);

        film[row] = backup;
    }

    static boolean canTest() {
        for (int j = 0; j < W; j++) {
            boolean ok = false;
            int count = 1;
            for (int i = 1; i < D; i++) {
                if (film[i][j] == film[i - 1][j]) {
                    count++;
                } else {
                    count = 1;
                }

                if (count >= K) {
                    ok = true;
                    break;
                }
            }
            // 한 열이라도 기준을 못 넘기면 전체 실패
            if (!ok) return false;
        }
        return true;
    }
}
