import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int N = progresses.length;
        Queue<process> q = new ArrayDeque<>();
        
        for(int i=0;i<N;i++){
            q.offer(new process(progresses[i],speeds[i]));
        }
        
        List<Integer> ans = new ArrayList<>();
        
        while(!q.isEmpty()){
            process cur = q.poll();
            int days = (100 - cur.progress + cur.speed - 1)/cur.speed;
            int count = 1;
            
            while(!q.isEmpty()){
                process next = q.peek();
                
                if(next.progress + (days*next.speed)>=100){
                    q.poll();
                    count++;
                }else{
                    break;
                }
            }
            
            ans.add(count);
        }
        int[] answer = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            answer[i] = ans.get(i);
        }
    
        return answer;
    }
    
    class process{
        int progress, speed;
        
        public process(int progress,int speed){
            this.progress = progress;
            this.speed = speed;
        }
    }
}