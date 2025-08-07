//어차피 N번째 지점에선 기름 못넣음
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long cost[], dist[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cost = new long[N+1];
        dist = new long[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N-1;i++){
            dist[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            cost[i] = Long.parseLong(st.nextToken());
        }

        long sum=0, mincost=cost[1];

        for(int i=1;i<N;i++){
            if(cost[i]<mincost){
                mincost=cost[i];
            }
            sum+=mincost*dist[i];
        }
        System.out.println(sum);

    }
}
