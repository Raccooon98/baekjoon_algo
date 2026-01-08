import java.io.*;
import java.util.*;

class Solution {
    private static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
    private static int ans =0;
    
    public int solution(int[] info, int[][] edges) {
        
        for(int i=0;i<info.length;i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for(int i=0;i<edges.length;i++){
            int x = edges[i][0];
            int y = edges[i][1];
            
            adj.get(x).add(y);
            adj.get(y).add(x);
        }
        
        boolean[] vis = new boolean[info.length];
        vis[0]=true;
        DFS(0,0,0,vis,info);
        
        return ans;
    }
    
    static void DFS(int cur, int sheep, int wolf, boolean[] vis,int[] info){
        if(info[cur]==0){
            sheep++;
        }else{
            wolf++;
        }
        
        if(wolf>=sheep)return;
        
        // vis[cur] = true;
        
        ans = Math.max(ans,sheep);
        
        for(int i=0;i<adj.size();i++){
            if(vis[i]){
                for(int x:adj.get(i)){
                    if(!vis[x]){
                        vis[x]=true;
                        DFS(x,sheep,wolf,vis,info);
                        vis[x] = false;
                    }
                }
            }
        }
        
        
    }
        
}