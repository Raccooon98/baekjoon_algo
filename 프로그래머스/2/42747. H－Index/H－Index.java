import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int len = citations.length;
        
        for(int i=1;i<=10000;i++){
            int h = i;
            int count=0;
            
            for(int j=0;j<len;j++){
                if(citations[j]>=h){
                    count++;
                }
            }
            
            if(count>=h) answer = h;
        }
        
        return answer;
    }
}