import java.io.*;
import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sum=0;
        Queue<Integer> q =new ArrayDeque<>();
        
        //일단 큐에 0으로 채우기
        for(int i=0;i < bridge_length; i++){
            q.offer(0);
        }
        
        for(int w: truck_weights){
            while(true){
                sum -= q.poll();
                answer++;
                
                if(sum+w<=weight){
                    q.offer(w);
                    sum+=w;
                    break;
                }else{
                    q.offer(0);
                }
            }
        }
        while(!q.isEmpty()){
            q.poll();
            answer++;
        }
        
        return answer;
    }
}