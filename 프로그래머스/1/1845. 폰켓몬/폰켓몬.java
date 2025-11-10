import java.io.*;
import java.util.*;

class Solution {
    static HashMap<Integer, Integer> map;
    public int solution(int[] nums) {
        map = new HashMap<>();
        
        int size = nums.length/2;
        
        for(int n : nums){
            if(map.containsKey(n)){
               int cnt = map.get(n);
                map.replace(n,cnt+1);
            }else{
                map.put(n,1);
            }
        }
        
        int answer = 0;
        int map_size = map.size();
        if(map_size>=size){
            answer = size;
        }else{
            answer = map_size;
        }
        
        
        return answer;
    }
}