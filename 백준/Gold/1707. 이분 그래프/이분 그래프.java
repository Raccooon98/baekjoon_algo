import java.io.*;
import java.util.*;
public class Main {
    static int[]  visited;

    static ArrayList<ArrayList<Integer>> adj;
    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int K = Integer.parseInt(br.readLine());

        for(int k=0;k<K;++k){
            st=new StringTokenizer(br.readLine()," ");
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            adj = new ArrayList<>();
            for(int i=0;i<=V;i++){
                adj.add(new ArrayList<>());
            }

            for(int e=0;e<E;++e){
                st=new StringTokenizer(br.readLine(), " ");
                int u=Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                adj.get(u).add(v);
                adj.get(v).add(u);
            }

            visited = new int[V+1];
            boolean isok=true;

            for(int i=0;i<=V;i++){
                if(visited[i]==0){
                    if(!BFS(i)){
                        isok=false;
                        break;
                    }
                }
            }

            if(isok){
                sb.append("YES\n");
            } else{
                sb.append("NO\n");
            }
        }

        System.out.println(sb.toString());
        br.close();
    }

    static boolean BFS(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start]=1;

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int next:adj.get(cur)){
                if(visited[next]==0){
                    visited[next]=3-visited[cur];
                    q.offer(next);
                }else if(visited[next]==visited[cur]){
                    return false;
                }
            }
        }

        return true;
    }
}
