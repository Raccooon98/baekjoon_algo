import java.util.*;
import java.io.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        if(cacheSize==0) return cities.length*5;
        
        int sumTime=0;
        LinkedList<String> cache = new LinkedList<>();
        
        for(String s:cities){
            String cur = s.toLowerCase();
            
            if(cache.contains(cur)){
                sumTime++;
                cache.remove(cur);
                cache.add(cur);
            }else{
                sumTime +=5;
                if(cache.size()>=cacheSize){
                    cache.removeFirst();
                }
                
                cache.add(cur);
            }
        }
        
        
        return sumTime;
    }
}