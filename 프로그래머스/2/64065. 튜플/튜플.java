import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String s) {
        
        
        String[] str = s.substring(2,s.length()-2).split("\\},\\{");
        
        Arrays.sort(str, (a,b) -> Integer.compare(a.length(),b.length()));
        
        List<Integer> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        
        for(String ss: str){
            String[] temp = ss.split(",");
            
            for(String num:temp){
                int n = Integer.parseInt(num);
                
                if(!set.contains(n)){
                    result.add(n);
                    set.add(n);
                }
            }
        }
        int len=result.size();
        int[] answer = new int[len];
        
        for(int i=0;i<len;i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}