import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int n:scoville){
            pq.offer(n);
        }
        
        while(pq.peek()<K&&pq.size()>=2){
            int first = pq.poll();
            int second = pq.poll();
            
            int newFood = first+second*2;
            pq.offer(newFood);
            answer++;
        }
        if(pq.peek() < K) return -1;
        
        return answer;
    }
}