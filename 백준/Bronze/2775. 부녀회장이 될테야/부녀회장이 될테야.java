//DP문제 같고 손으로 직접 써본 결과 dp[i][j] = dp[i-1][j]+dp[i][j-1] 인듯
//1행 -> 1,2,3,4,5....
//1열 -> 1,1,1,1,1,1....
//이렇게 채워놓고 시작하기
import java.io.*;
import java.util.*;
public class Main {
    static int T;
    static int dp[][];
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb =new StringBuilder();
        T = Integer.parseInt(br.readLine());
        dp = new int[15][15];
        for(int i=0;i<=14;i++){
            dp[0][i]=i;
            dp[i][1]=1;
        }

        for(int i=1;i<=14;i++){
            for(int j=1;j<=14;j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        while(0<T--){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[k][n]+"\n");
        }

        System.out.println(sb);
    }
}
