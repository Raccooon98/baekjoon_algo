import java.io.*;
import java.util.*;

class Solution {
    private static Stack<Character> stack = new Stack<>();
    private static int count;
    private static String[] answer;
    
    public String[] solution(String[] s) {
        answer = new String[s.length];
        
        int cnt=0;
        for(int n=0;n<s.length;n++){
            stack.clear();
            count=0;
            
            for(int i=0;i<s[n].length();i++){
                char cur = s[n].charAt(i);
                if(cur=='1'){
                    stack.push('1');
                }else{
                    if(stack.size()>=2){
                        char first = stack.pop();
                        char second = stack.pop();
                        
                        if(first=='1'&&second=='1'){
                            count++;
                        }else{
                            stack.push(second);
                            stack.push(first);
                            stack.push(cur);
                        }
                    }else{
                        stack.push(cur);
                    }
                }
            }
            for(int i=0;i<count;i++){
            Stack<Character> tmp = new Stack<>();
            
                while(true){
                    if(stack.isEmpty()){
                        stack.push('1');
                        stack.push('1');
                        stack.push('0');
                        while(!tmp.isEmpty()){
                            stack.push(tmp.pop());
                        }
                        break;
                    }else{
                        char cur = stack.pop();
                        if(cur=='0'){
                            stack.push(cur);
                            stack.push('1');
                            stack.push('1');
                            stack.push('0');
                        
                            while(!tmp.isEmpty()){
                                stack.push(tmp.pop());
                            }
                            break;
                        }else{
                            tmp.push(cur);
                        }
                    }
                } 
            }
            
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            String Result = sb.reverse().toString();

            answer[n] = Result;
        }
        
        
        
        return answer;
    }
    
    
}