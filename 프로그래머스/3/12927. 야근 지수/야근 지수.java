import java.io.*;
import java.util.*;

class Solution {
    
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int work:works){
            pq.offer(work);
        }
        
        while(n>0&&!pq.isEmpty()){
            int num = pq.poll();
            if(num>0) pq.offer(num-1);
            n--;
        }
        
        while(!pq.isEmpty()){
            long num = pq.poll();
            answer+= (num * num);
        }
        
        return answer;
    }
}