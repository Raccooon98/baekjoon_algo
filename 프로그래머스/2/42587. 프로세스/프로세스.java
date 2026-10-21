import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Pair> q =new ArrayDeque<>();
        for(int i = 0; i < priorities.length; i++){
            q.offer(new Pair(i,priorities[i]));
        }
        
        int count=0;
        
        while(!q.isEmpty()){
            Pair cur = q.poll();
            
            boolean hasMax=false;
            for(Pair p : q){
                if(p.val>cur.val){
                    hasMax=true;
                }
            }
            
            if(hasMax){
                q.offer(cur);
            }else{
                count++;
                if(cur.loc == location) return count;
            }
        }
        
        return answer;
    }
    
    class Pair{
        int loc, val;
        
        public Pair(int loc, int val){
            this.loc=loc;
            this.val=val;
        }
    }
}