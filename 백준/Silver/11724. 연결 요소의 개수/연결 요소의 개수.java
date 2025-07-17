import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<ArrayList<Integer>> adj;
    static boolean [] visited;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        adj=new ArrayList<>();
        for(int i=0;i<=N;++i){
            adj.add(new ArrayList<>());
        }
        visited= new boolean[N+1];

        for(int i=0;i<M;++i){
            st = new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int count=0;

        for(int i=1;i<=N;i++){
            if(!visited[i]){
                DFS(i);
                count++;
            }
        }

        System.out.println(count);
    }

    static void DFS(int node){
        visited[node] = true;
        for(int next:adj.get(node)){
            if(!visited[next])
                DFS(next);
        }
    }
}
