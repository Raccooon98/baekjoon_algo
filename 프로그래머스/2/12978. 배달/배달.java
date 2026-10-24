import java.io.*;
import java.util.*;

class Solution {
    static List<Node>[] adj;
    static final int INF = Integer.MAX_VALUE;
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int len = road.length;
        
        adj = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            adj[i] = new ArrayList<>();
        }
        
        for(int i=0;i<len;i++){
            int a = road[i][0];
            int b = road[i][1];
            int c = road[i][2];
            
            adj[a].add(new Node(b,c));
            adj[b].add(new Node(a,c));
        }
        
        int dist[] = dijkstra(1, N, adj);      
        for(int d:dist){
            if(d <= K){
                answer++;
            }    
        }
        
        return answer;
    }
    
    static int[] dijkstra(int st, int N, List<Node>[] adj){
        int[] dist = new int[N+1];
        Arrays.fill(dist, INF);
        
        PriorityQueue<Node> pq = new PriorityQueue<>(
            (o1,o2) -> {
                return Integer.compare(o1.cost, o2.cost);
            }
        );
        
        pq.offer(new Node(st,0));
        dist[st] = 0;
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int now = cur.to;
            int nowcost = cur.cost;
            
            if(dist[now]< nowcost) continue;
            for(Node next : adj[now]){
                int cost = dist[now] + next.cost;
                
                if(cost<dist[next.to]){
                    dist[next.to] = cost;
                    pq.offer(new Node(next.to, cost));
                }
            }
        }
        return dist;
    }
    
    static class Node{
        int to, cost;
        
        public Node(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
    }
}