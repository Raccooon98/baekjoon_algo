import java.util.*;
class Solution {
    static ArrayList<Integer> adj[];
    static boolean visited[];
    public int solution(int n, int[][] wires) {
        int answer = -1;
        
        adj = new ArrayList[n+1];
        int min =Integer.MAX_VALUE;
        
        for(int i=0;i<=n;i++){
            adj[i] = new ArrayList<>();
        }
        
        for(int i=0;i<n-1;i++){
            adj[wires[i][0]].add(wires[i][1]);
            adj[wires[i][1]].add(wires[i][0]);
        }
        
        for (int i = 0; i < wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
 
            visited = new boolean[n + 1];
 
            // 해당 간선을 그래프에서 제거
            adj[v1].remove(Integer.valueOf(v2));
            adj[v2].remove(Integer.valueOf(v1));
 
            int cnt = dfs(1);
 
            int diff = Math.abs(cnt - (n - cnt));
            min = Math.min(min, diff);
 
            // 그래프에 다시 간선 추가
            adj[v1].add(v2);
            adj[v2].add(v1);
        }
 
        return min;
    }
    
    private static int dfs(int v){
        visited[v] = true;
        int cnt = 1;
 
        for (int next : adj[v]) {
            if (!visited[next]) {
                cnt += dfs(next);
            }
        }
 
        return cnt;
    }
}