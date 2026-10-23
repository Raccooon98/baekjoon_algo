import java.io.*;
import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int len = number.length() - k;
        
        for(int i=0;i<number.length();i++){
            char c = number.charAt(i);
            
            while(sb.length() > 0 && sb.charAt(sb.length() - 1) < c && k > 0){
                sb.deleteCharAt(sb.length()-1);
                k--;
            }
            
            sb.append(c);
        }
        
        
        return sb.toString().substring(0,len);
    }
}