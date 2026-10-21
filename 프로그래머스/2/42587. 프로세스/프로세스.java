import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Pair> q =new ArrayDeque<>();
        for(int i = 0; i < priorities.length; i++){
            q.offer(new Pair(i,priorities[i]));
        }
        
        int max = Collections.max(q, (a1,a2)->Integer.compare(a1.val, a2.val)).val;
        int count=0;
        while(!q.isEmpty()){
            Pair cur = q.poll();
            if(cur.val>=max){
                count++;
                if(cur.loc==location) return count;
                max = Collections.max(q, (a1,a2)->Integer.compare(a1.val, a2.val)).val;
            }else{
                q.offer(cur);
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