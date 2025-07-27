//M의 크기를 봤을때 M의 케이스마다 합을 구하면 시간초과(직접해봄)
//그러면 DP아니면 다른 방법 찾아보기
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] presum = new int[N+1][N+1];

        for(int i=1;i<=N;++i){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;++j){
                int curval = Integer.parseInt(st.nextToken());
                presum[i][j] = curval + presum[i-1][j] + presum[i][j-1] - presum[i-1][j-1];
            }
        }

        for(int m=0; m<M; ++m){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int sum=0;

            sum+=presum[x2][y2]-presum[x1-1][y2]-presum[x2][y1-1]+presum[x1-1][y1-1];

            System.out.println(sum);
        }
    }
}
