import java.io.*;
import java.util.*;

class Solution {
    static int time=0;
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new ArrayDeque<>();
        int curWeight=0;
        
        for(int i=0;i<truck_weights.length;i++){
            int truck = truck_weights[i];
            while(true){
                if(q.isEmpty()){
                    q.offer(truck);
                    curWeight+=truck;
                    time++;
                    break;
                }else if(q.size()==bridge_length){
                    curWeight-=q.poll();
                }else if(curWeight+truck<=weight){
                    q.offer(truck);
                    curWeight+=truck;
                    time++;
                    break;
                }else{
                    q.offer(0);
                    time++;
                }
            }
        }
        
        
        return time+bridge_length;
    }
}