import java.util.*;
import java.io.*;

class Solution {
    static boolean[] vis;
    static int len;
    static int[][] board;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        len = computers.length;
        vis = new boolean[len];
        board = computers.clone();
        
        int count = 0;
        for(int i=0;i<len;i++){
            if(!vis[i]){
                count++;
                BFS(i);
            }
        }
        
        return count;
    }
    
    static void BFS(int cur){
        vis[cur] = true;
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(cur);
        
        while(!q.isEmpty()){
            int now = q.poll();
            
            for(int i=0;i<len;i++){
                if(i == now) continue;
                if(board[now][i] ==1){
                    if(!vis[i]){
                        q.offer(i);
                        vis[i]=true;
                    }
                }
            }
        }
        
    }
}