import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[] arr, input;
    static boolean[] vis;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        input = new int[N];
        vis = new boolean[N];
        arr = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);

        DFS(0);
        System.out.println(sb);
    }

    static void DFS(int depth){
        if(depth == M){
            for(int n:arr){
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0;i<N;i++){
            if(!vis[i]){
                vis[i] = true;
                arr[depth] = input[i];
                DFS(depth+1);
                vis[i] = false;
            }
        }
    }
}
