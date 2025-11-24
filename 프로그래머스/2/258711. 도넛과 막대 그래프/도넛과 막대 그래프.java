// (진입차수, 진출차수) (1,1)이면 도넛, (1,0) 이면 막대, (2,2)이면 8자
// 들어오는 간선이 없으면 생성 정점이다
import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, Integer> outDegree = new HashMap<>();
        
        int[] answer = new int[4];
            
        for(int[] node : edges){
            outDegree.put(node[0],outDegree.getOrDefault(node[0],0)+1);
            inDegree.put(node[1],inDegree.getOrDefault(node[1],0)+1);
        }
        
        for(int node : outDegree.keySet()){
            if(outDegree.get(node)>1){
                if(!inDegree.containsKey(node)){
                    answer[0] = node;
                }else{
                    answer[3]++;
                }
            }
        }
        
        for(int node : inDegree.keySet()){
            if(!outDegree.containsKey(node)){
                answer[2]++;
            }
        }
        
        answer[1] = outDegree.get(answer[0])-answer[2]-answer[3];
        return answer;
    }
}