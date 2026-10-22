import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] vis = new boolean[n];
        int count = 0;
        for(int i = 0; i < n; i++){
            if(vis[i] == false){
                BFS(computers, vis, i);
                count++;
            }
        }
        
        return count;
    }
    
    static void BFS(int[][] computers, boolean[] vis, int cur){
        int len = computers.length;
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(cur);
        vis[cur]=true;
        
        while(!q.isEmpty()){
            int c = q.poll();
            
            for(int i=0;i<len;i++){
                if(computers[c][i] != 1) continue;
                int next = i;
                if(vis[next]) continue;
                q.offer(next);
                vis[next]=true;
            }
        }
    }
}