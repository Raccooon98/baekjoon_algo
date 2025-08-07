//1,3,4개 가져갈 수 있음
//dp[0] = 패
//dp[1] = 승
//dp[2] = 패
//dp[3] = 승
//dp[4] = 승
//dp[5] = 승
//dp[6] = 승
//dp[7] = 페 ... 7로 나눴을때 나머지가 0, 2 일떄만 짐
import java.io.*;
import java.util.*;

public class Main{
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        System.out.println((N%7==0||N%7==2)?"CY":"SK");
    }
}
