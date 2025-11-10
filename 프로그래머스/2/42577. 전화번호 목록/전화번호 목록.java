import java.io.*;
import java.util.*;

class Solution {
    private static Set<String> set;
    
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        set = new HashSet<>(Arrays.asList(phone_book));
        
        for(String phone : phone_book){
            for(int i=0;i<phone.length();i++){
                if(set.contains(phone.substring(0,i))){
                    answer = false;
                }
            }
        }
        return answer;
    }
}