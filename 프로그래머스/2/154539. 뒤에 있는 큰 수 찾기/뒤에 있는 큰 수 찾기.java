import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] numbers) {
        int len = numbers.length;
        int[] answer = new int[len];
        Stack<Integer> stack = new Stack<>();
        
        for(int i=len-1;i>=0;i--){
            
            while(!stack.isEmpty() && stack.peek()<=numbers[i]){
                stack.pop();
            }
            
            if(stack.isEmpty()){
                answer[i]=-1;
            }else{
                answer[i] = stack.peek();
            }
            
            stack.push(numbers[i]);
            
        }
        
        return answer;
    }
}