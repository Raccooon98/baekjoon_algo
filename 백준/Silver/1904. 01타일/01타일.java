//N 일때 ~가지 -> DP로 접근해보기
//1 -> 1
//2 -> 2
//3 -> 3
//4 -> 5
import java.io.*;
import java.util.*;

public class Main {
    static int arr[]=new int[1000001];
    public static void main(String[] args)throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;

        for(int i=3;i<1000001;i++){
            arr[i] = -1;
        }

        System.out.println(cal(N));


    }
    private static int cal(int n){
        if(arr[n]==-1){
            arr[n]=(cal(n-1)+cal(n-2))%15746;
        }
        return arr[n];
    }
}
