
import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;
    static boolean[] vis;
    static int N,M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        vis = new boolean[N];

        DFS(0);
        System.out.println(sb);
    }

    static void DFS(int depth){
        if(depth == M){
            for(int n : arr){
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0;i<N;i++){
            if(!vis[i]){
                vis[i] = true;
                arr[depth] = i + 1;
                DFS(depth + 1);
                vis[i]=false;
            }
        }
    }
}
