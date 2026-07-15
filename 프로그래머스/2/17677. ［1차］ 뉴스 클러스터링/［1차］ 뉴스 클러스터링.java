import java.io.*;
import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        List<String> splitedString1 = getList(str1);
        List<String> splitedString2 = getList(str2);
        
        int intersection=0;
        int union=0;
        
        List<String> copy = new ArrayList<>(splitedString2);
        
        for(String s: splitedString1){
            if(copy.contains(s)){
                intersection++;
                copy.remove(s);
            }
        }
        
        union = splitedString1.size() + splitedString2.size() - intersection;
        
//         int left=0;
//         int right=1;
//         while(right<len1){
//             String tmp=str1.substring(left,right);
//             if(isAlpha(tmp)) splitedString1.add(tmp);
            
//             left++;
//             right++;
//         }
        
//         left=0;
//         right=1;
//         while(right<len2){
//             String tmp=str2.substring(left,right);
//             if(isAlpha(tmp)) splitedString2.add(tmp);
            
//             left++;
//             right++;
//         }
        
        if (splitedString1.isEmpty() && splitedString2.isEmpty()) return 65536;
        
        answer = (int)(((double)intersection/union) * 65536);
        
        return answer;
    }
    
    static List<String> getList(String s){
        List<String> result = new ArrayList<>();
        for(int i=0;i<s.length()-1;i++){
            String temp = s.substring(i,i+2);
            if(isAlpha(temp)){
                result.add(temp);
            }
        }
        
        return result;
    }
    
    static boolean isAlpha(String s){
        for(char c:s.toCharArray()){
            if(c<'a'||c>'z'){
                return false;
            }
        }
        return true;
    }
}