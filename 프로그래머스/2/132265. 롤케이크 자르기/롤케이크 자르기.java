import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int len = topping.length;
        Map<Integer, Integer> broMap = new HashMap<>();
        
        for(int i=0;i<len;i++){//오른쪽에 각 토핑별로 몇개있는지 초기화
            broMap.put(topping[i],broMap.getOrDefault(topping[i],0)+1);
        } 
        
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<len;i++){
            set.add(topping[i]);
            if(broMap.get(topping[i])==1){
                broMap.remove(topping[i]);
            }else{
                broMap.replace(topping[i],broMap.get(topping[i])-1);
            }
            
            int lsize = set.size();
            int rsize = broMap.size();
            
            if(lsize==rsize) answer++;
        }
        
        
        return answer;
    }
}