import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int arr[];
    static int INF=909090909;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        int right=-1;
        int left=0;

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            right = Math.max(arr[i],right);
        }

        while(left<right){
            int mid=(left+right)/2;
            if(func(mid)<=M)
                right=mid;
            else
                left=mid+1;
        }
        System.out.println(right);
    }

    static int func(int mid){
        int cnt=1;
        int min = INF;
        int max = -INF;

        for(int i=0;i<N;i++){
            min = Math.min(min,arr[i]);
            max = Math.max(max,arr[i]);
            if(max-min>mid){
                cnt++;
                max = -INF;
                min=INF;
                i--;
            }
        }
        return cnt;
    }
}