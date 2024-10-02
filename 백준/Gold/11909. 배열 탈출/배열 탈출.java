import java.util.Arrays;
import java.util.Scanner;

//다익스트라?? DP?? 잘 모르겠음

public class Main {
    static int N;
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N=sc.nextInt();

        arr=new int[N+1][N+1];

        for(int[] row:arr){
            Arrays.fill(row,-100000000);
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                arr[i][j]=sc.nextInt();
            }
        }

        int dp[][] = new int[N+1][N+1];
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(i==1&&j==1){
                    //시작점이면 0 넣고 시작해주기
                    dp[i][j]=0;
                    continue;
                }

                int cost=0;
                if(arr[i][j-1]>arr[i][j]){
                    cost=0;
                }else{
                    cost=arr[i][j]-arr[i][j-1]+1;
                }

                int cost2=0;
                if(arr[i-1][j]>arr[i][j]){
                    cost2=0;
                }else{
                    cost2=arr[i][j]-arr[i-1][j]+1;
                }

                dp[i][j]=dp[i][j-1]+cost;
                dp[i][j]=Math.min(dp[i-1][j]+cost2,dp[i][j]);
            }

        }

        System.out.println(dp[N][N]);

    }
}

