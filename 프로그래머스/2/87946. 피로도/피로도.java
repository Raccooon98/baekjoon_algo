import java.io.*;
import java.util.*;

class Solution {
    static int answer = -1;
    static boolean[] vis;
    
    public int solution(int k, int[][] dungeons) {
        int len = dungeons.length;
        vis = new boolean[len];
        
        dfs(k,dungeons,0);
        
        return answer;
    }
    
    static void dfs(int cur, int[][]arr, int cnt){
        answer = Math.max(answer, cnt);
        
        for(int i=0;i<arr.length;i++){
            if(!vis[i] && cur>=arr[i][0]){
                vis[i] = true;
                
                dfs(cur - arr[i][1], arr, cnt+1);
                vis[i]=false;
            }
        }
    }
}