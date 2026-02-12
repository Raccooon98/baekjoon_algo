import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] order) {
        int cnt = 0;
        int len = order.length;
        Stack<Integer> stack = new Stack<>();
        
        for(int i=1;i<=len;i++){
            stack.push(i);
            
            while (!stack.isEmpty() && stack.peek() == order[cnt]) {
                stack.pop();
                cnt++;
            }
        }
        
        return cnt;
    }
}