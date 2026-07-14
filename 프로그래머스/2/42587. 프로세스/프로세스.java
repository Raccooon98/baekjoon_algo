import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int len = priorities.length;
        
        Queue<Pair> q= new LinkedList<>();
        for(int i=0;i<len;i++){
            q.offer(new Pair(priorities[i],i));
        }
        int count=0;
        while(!q.isEmpty()){
            Pair cur = q.poll();
            boolean canRun=true;
    
            for(Pair next: q){
                if(cur.priority<next.priority){
                    canRun = false;
                    break;
                }
            }
            
            if(canRun){
                count++;
                if(cur.idx == location){
                    answer=count;
                    break;
                } 
            }else{
                q.offer(cur);
            }
            
            
        }
        
        return answer;
    }
    
    static class Pair{
        int priority;
        int idx;
        
        public Pair(int priority, int idx){
            this.priority=priority;
            this.idx=idx;
        }
    }
}