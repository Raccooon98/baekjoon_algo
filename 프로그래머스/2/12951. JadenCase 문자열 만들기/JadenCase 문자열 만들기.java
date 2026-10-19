//공백만 연속으로 나올 수 있기 떄문에 StringTokenizer를 사용하면 공백이 다 사라지기 때문에 안됨
import java.io.*;
import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb=new StringBuilder();
        int len = s.length();
        
        boolean isFirst = true;
        for(int i=0;i<len;i++){
            char c = s.charAt(i);
            
            if(c==' '){
                sb.append(c);
                isFirst = true;
                
            }else{
                if(isFirst){
                    sb.append(Character.toUpperCase(c));
                    isFirst = false;
                }else{
                    sb.append(Character.toLowerCase(c));
                }
            }
        }
        
        return sb.toString();
    }
}