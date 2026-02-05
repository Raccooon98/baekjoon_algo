//그리디? 이분탐색? 제일 긴 친구부터 탐색 시키기 
//배열을 두개 이어붙여서 슬라이딩 윈도우로 밀면 될것 같음
import java.util.*;
import java.io.*;

class Solution {
    static int answer = 0;
    static int[] weak;
    static int[] dist;
    static boolean[] vis;
    static int[] result;
    
    public int solution(int n, int[] weak, int[] dist) {
        Solution.weak=weak;
        Solution.dist=dist;
        int dlen =dist.length;
        answer = dlen+1;
        vis = new boolean[dlen];
        result = new int[dlen];
        
        int wlen = weak.length;
        int[] temp= new int[wlen*2];
        
        for(int i=0;i<wlen;i++){
            temp[i] = weak[i];
            temp[i+wlen] = weak[i]+n;
        }
        
        DFS(0,temp);
        
        return answer>dlen?-1:answer;
    }
    
    static void DFS(int depth, int[] temp){
        if(depth == dist.length){
            check(temp);
            return;
        }
        
        for(int i=0;i<dist.length;i++){
            if(vis[i]) continue;
            
            vis[i] = true;
            result[depth] = dist[i];
            DFS(depth+1,temp);
            vis[i] = false;
        }
    }
    
    static void check(int[] temp){
        int wlen = weak.length;
        
        for(int i=0;i<wlen;i++){
            int count=1;
            int last = temp[i]+result[0];
            
            for(int j=i;j<i+wlen;j++){
                if(temp[j]>last){
                    count++;
                    if(count>dist.length) break;
                    last = temp[j]+result[count-1];
                }
            }
            
            answer = Math.min(answer,count);
        }
    }
}