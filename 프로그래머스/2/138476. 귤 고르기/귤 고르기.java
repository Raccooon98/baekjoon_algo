import java.util.*;
import java.io.*;

class Solution {
    static Map<Integer,Integer> map = new HashMap<>();
    static int[] arr;
    
    public int solution(int k, int[] tangerine) {
        int len = tangerine.length;
        for(int i = 0; i < len; i++){
            map.put(tangerine[i],map.getOrDefault(tangerine[i],0)+1);
        }
        
        int Size = map.size();
        List<Integer> list = new ArrayList<>(map.values());
        list.sort(Collections.reverseOrder());
        
        int sum=0;
        int answer=0;
        for(int num:list){
            sum += num;
            answer++;
            if(sum>=k) break;
        }
        
        return answer;
    }
}