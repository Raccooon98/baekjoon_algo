import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        
        for(char c: s.toCharArray()){
            if(stack.isEmpty()){
                if(c == ')') 
                    return false;
                else stack.add(c);
            }else{
                if(c!='(')
                    stack.pop();
                else
                    stack.add(c);
            }
        }

        if(stack.isEmpty()) answer = true;
        else answer = false;
        return answer;
    }
}