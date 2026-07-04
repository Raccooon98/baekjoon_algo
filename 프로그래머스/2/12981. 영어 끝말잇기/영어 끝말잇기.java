import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int[] count = new int[n];
        int num = words.length;
        Set<String> set = new HashSet<>();
        
        int idx=1 , cnt=1;
        set.add(words[0]);
        count[0]++;
        String prestr=words[0];
        
        
        for(int i=1;i<num;i++){
            cnt++;
            count[idx]++;
            int len = prestr.length();
            String s = words[i];
            
            if(set.contains(s)||prestr.charAt(len-1)!=s.charAt(0)){
                cnt--;
                break;
            }else{
                set.add(s);
            }
            idx = (idx + 1) % n;
            prestr = s;
        }
        
        if(cnt==num){
            answer[0] = 0;
            answer[1] = 0;
        }else{
            answer[0] = idx+1;
            answer[1] = count[idx];    
        }
        
        return answer;  
    }
}