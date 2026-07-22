import java.io.*;
import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        // DFS(x,0,n);
        if(x==y) return 0;
        
        Queue<int[]> q = new ArrayDeque<>();
        boolean[] vis = new boolean[y+1];
        
        q.offer(new int[]{x,0});
        vis[x]=true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            int curx = cur[0];
            int count = cur[1];
            
            int[] next = {curx+n, curx*2,curx*3};
            for(int num : next){
                if(num == y){
                    return count+1;
                }
                
                if(num<y&&!vis[num]){
                    vis[num]=true;
                    q.offer(new int[]{num,count+1});
                }
            }
        }
        
        
        return -1;
    }
    
//     static void DFS(int sum, int count, int num){
//         if(sum>=target){
//             if(sum==target){
//                 min = Math.min(count,min);
//             }
            
//             return;  
//         } 
        
//         DFS(sum+num, count+1,num);
//         DFS(sum*2, count+1,num);
//         DFS(sum*3, count+1,num);
//     }
}