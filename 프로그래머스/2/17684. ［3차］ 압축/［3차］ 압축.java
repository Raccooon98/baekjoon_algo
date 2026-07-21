import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String msg) {
        int len = msg.length();
        List<Integer> result = new ArrayList<>();
        
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<26;i++){
            map.put(Character.toString('A'+i), i+1);
        }
        
        int left=0;
        while(left<len){
            StringBuilder sb = new StringBuilder();
            int right = left;
            
            while (right < len) {
                sb.append(msg.charAt(right));
                if (!map.containsKey(sb.toString())) {
                    sb.deleteCharAt(sb.length() - 1);
                    break;
                }
                right++;
            }
            
            String w = sb.toString();
            result.add(map.get(w));
            
            if (right < len) {
                sb.append(msg.charAt(right));
                map.put(sb.toString(), map.size() + 1);
            }
            
            left+=w.length();
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}