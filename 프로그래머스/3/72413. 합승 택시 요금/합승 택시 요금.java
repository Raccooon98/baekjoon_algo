import java.io.*;
import java.util.*;

class Solution {
    static final int INF = Integer.MAX_VALUE;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = INF;
        int len = fares.length;
        List<Node>[] gragh = new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            gragh[i] = new ArrayList<>();
        }
        
        for(int i=0;i<len;i++){
            int from = fares[i][0];
            int to = fares[i][1];
            int cost = fares[i][2];
            
            gragh[from].add(new Node(to, cost));
            gragh[to].add(new Node(from,cost));
        }
        
        int[] distS = dijkstra(n, s, gragh);
        int[] distA = dijkstra(n, a, gragh);
        int[] distB = dijkstra(n, b, gragh);
        
        for(int i=1;i<=n;i++){
            if(distS[i]==INF|| distA[i]==INF||distB[i]==INF) continue;
            
            int sum = distS[i]+distA[i]+distB[i];
            answer = Math.min(sum,answer);
        }
        
        return answer;
    }
    
    static int[] dijkstra(int N, int st, List<Node>[] gragh){
        int dist[] = new int[N+1];
        Arrays.fill(dist, INF);
        
        PriorityQueue<Node> pq = new PriorityQueue<>(
            (o1,o2) -> {return Integer.compare(o1.cost, o2.cost);}
        );
        
        pq.offer(new Node(st,0));
        dist[st] = 0;
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int now = cur.to;
            int nowCost = cur.cost;
            
            if(dist[now]<nowCost) continue;
            
            for(Node next:gragh[now]){
                int cost = dist[now] + next.cost;
                
                if(cost < dist[next.to]){
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
            this.to=to;
            this.cost=cost;
        }
    }
}