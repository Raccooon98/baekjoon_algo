import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;
    static boolean[] vis;
    static int N,M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        vis = new boolean[N+1];

        DFS(0,1);

        System.out.println(sb);
    }

    static void DFS(int depth,int cur){
        if(depth == M){
            for(int n: arr){
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=cur; i<=N; i++){
            arr[depth] = i;
            DFS(depth+1,i);
        }
    }
}
