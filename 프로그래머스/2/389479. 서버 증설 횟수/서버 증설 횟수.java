import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        PriorityQueue<INFO> pq = new PriorityQueue<>((o1, o2) -> o1.endTime - o2.endTime);
        int size = 0;  // 현재 서버의 개수 
        int count = 0; // 증설된 서버 횟수  
        for(int i = 0; i < 24; i++){
            
            while(!pq.isEmpty() && pq.peek().endTime==i){
                size -= pq.poll().num;
            }
            
            int need = players[i] / m;
            int more = size-need;
            
            if(more<0){
                more = -more;
                size +=more;
                count += more;
                pq.offer(new INFO(i + k , more));
            }
        }
        return count;
    }
    private static class INFO{
        int endTime, num;
        
        public INFO(int t,int n){
            this.endTime = t;
            this.num = n;
        }
    }
}