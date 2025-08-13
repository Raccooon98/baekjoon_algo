//DFS로 움직인 횟수 세고 최대값 갱신해서 저장하기 or DP로 풀기??
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int board[][], dp[][];
    static int max_cnt = Integer.MIN_VALUE;

    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {1, 0, -1, 0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        //러프하게 한 점씩 잡아서 최대 거리 체크하기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                max_cnt = Math.max(max_cnt,DFS(i, j));
            }
        }

        System.out.println(max_cnt);
    }

    private static int DFS(int x, int y) {
        if(dp[x][y]!=0){
            return dp[x][y];
        }

        //초기 출발점이면 1
        dp[x][y]=1;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            if (board[nx][ny] <= board[x][y]) continue;

            dp[x][y] = Math.max(dp[x][y],DFS(nx,ny)+1);

        }

        return dp[x][y];
    }
}
