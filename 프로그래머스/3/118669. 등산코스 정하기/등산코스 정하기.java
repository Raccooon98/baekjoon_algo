import java.util.*;
import java.io.*;

class Solution {
    static final int INF = Integer.MAX_VALUE;
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = new int[2];
        List<Node>[] gragh = new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            gragh[i] = new ArrayList<>();
        }
        
        boolean[] isGate=new boolean[n+1];
        boolean[] isSummit = new boolean[n+1];
        for(int gate: gates) isGate[gate] = true;
        for(int summit: summits) isSummit[summit] = true;
        
        
        for(int i=0;i<paths.length;i++){
            int from = paths[i][0];
            int to = paths[i][1];
            int cost = paths[i][2];
            
            gragh[from].add(new Node(to,cost));
            gragh[to].add(new Node(from,cost));
        }
        
        int[] dist = dijkstra(n,gates,gragh,isGate,isSummit);
        
        int minDist=INF;
        int minIdx=0;
        Arrays.sort(summits);
        for(int s : summits){
            if(dist[s]<minDist){
                minDist=dist[s];
                minIdx = s;
            }
        }
        answer[0] = minIdx;
        answer[1] = minDist;
        return answer;
    }
    
    static int[] dijkstra(int n, int[] gates, List<Node>[] gragh, boolean[] isGate, boolean[] isSummit){
        int[] dist = new int[n+1];
        Arrays.fill(dist,INF);
        PriorityQueue<Node> pq = new PriorityQueue<>(
            (o1,o2)->{ return Integer.compare(o1.cost,o2.cost);}
        );
        
        for(int gate:gates){
            dist[gate]=0;
            pq.offer(new Node(gate,0));
        }
        
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int now = cur.to;
            int nowCost = cur.cost;
            
            if(dist[now]<nowCost || isSummit[now]) continue;
            for(Node next:gragh[now]){
                int cost = Math.max(next.cost, dist[now]);
                
                if(isGate[next.to]) continue;
                if(cost<dist[next.to]){
                    dist[next.to] = cost;
                    pq.offer(new Node(next.to,cost));
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