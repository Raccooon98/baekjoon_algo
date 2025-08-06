//독립 집합 뜻 이해하는데 한참 걸림.. -> 서로 인접한 정점끼리 못고름: 간선으로 연결되어있는 애들은 제외시킨다~ 이말
import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int cost[];
    static int check[][];
    static boolean visited[];
    static ArrayList<Integer> result = new ArrayList<>();
    static ArrayList<Integer> adj[];
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb =new StringBuilder();

        cost = new int[N+1];
        check = new int[N+1][2];
        visited = new boolean[N+1];
        adj = new ArrayList[N+1];


        StringTokenizer st =new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            cost[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<=N;i++){
            adj[i] =new ArrayList<>();
        }

        for (int i = 1; i <N; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }

        DFS(1);

        Arrays.fill(visited,false);
        if(check[1][0]>check[1][1]){
            System.out.println(check[1][0]);
            func(1,0);
        }else{
            System.out.println(check[1][1]);
            func(1,1);
        }

        Collections.sort(result);

        for(int n:result){
            sb.append(n+" ");
        }
        System.out.println(sb);

    }

    public static void DFS(int cur){
        int size = adj[cur].size();

        check[cur][0] = 0;
        check[cur][1] = cost[cur];
        visited[cur]=true;

        for(int i=0;i<size;i++){
            int next = adj[cur].get(i);
            if(!visited[next]){
                DFS(next);

                check[cur][0] += Math.max(check[next][0],check[next][1]);
                check[cur][1] += check[next][0];
            }
        }
    }

    public static void func(int cur, int inc){
        visited[cur] = true;

        if(inc == 1){
            result.add(cur);
            for(int next:adj[cur]){
                if(!visited[next]){
                    func(next,0);
                }
            }
        }else{
            for(int next:adj[cur]){
                if(!visited[next]){
                    if(check[next][1]>check[next][0]){
                        func(next,1);
                    }else
                        func(next,0);
                }
            }
        }
    }
}
