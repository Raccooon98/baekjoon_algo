//participant 배열에 기반으로 해시맵에서 count올리고 completion에 있는 만큼 감소시킨다음 value가 0이 아닌사람만 return
import java.io.*;
import java.util.*;

class Solution {
    private static HashMap<String, Integer> map; 
    public String solution(String[] participant, String[] completion) {
        StringBuilder sb = new StringBuilder();
        map = new HashMap<>();
        
        for(String s : participant){
            if(!map.containsKey(s)){
                map.put(s,1);
            }else{
                int cnt = map.get(s);
                map.replace(s,cnt+1);
            }
        }
        
        for(String s : completion){
            int cnt = map.get(s);
            if(cnt==1){
                map.remove(s);
            }else{
                map.replace(s,cnt-1);
            }
        }
        
        for(Map.Entry<String, Integer> entry: map.entrySet()){
            sb.append(entry.getKey());
        }
        return sb.toString();
    }
}