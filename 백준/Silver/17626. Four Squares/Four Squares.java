//N이 50000이라서 완전탐색으로 문제 해결 가능할듯
// 1 -> 1^2 1개
// 2 -> 1^2 + 1^2 2개
// 3 -> 1^2 + 1^2 + 1^2 3개
// 4 -> 2^2 1개
// 5 -> 2^2 + 1^2 2개
// 6 -> 2^2 + 1^2 + 1^2 3개
// 7 -> 2^2 + 1^2 + 1^2 +1^2 4개
// 8 -> 2^2 + 2^2 2개
// 9 -> 3^2 1개
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args)throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int min = Integer.MAX_VALUE;
        int [] dp =new int[N+1];
        dp[1]=1;
        for(int i=2;i<=N;i++){
            min = Integer.MAX_VALUE;
            for(int j=1;j*j<=i;j++){
                int num = i-j*j;
                min=Math.min(min,dp[num]);
            }
            dp[i] = min+1;
        }

        System.out.println(dp[N]);
    }
}
