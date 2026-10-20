import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int countn = 0;
        String s = Integer.toBinaryString(n);
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1') countn++;
        }
        
        int num =n+1;
        while(true){
            String temp = Integer.toBinaryString(num);
            
            int cnt=0;
            for(int i=0;i<temp.length();i++){
                if(temp.charAt(i)=='1') cnt++;
            }
            
            if(countn == cnt) break;
            else num++;
        }
        
        return num;
    }
}