import java.util.*;
import java.io.*;

class Solution {
    static int len, T;
    static int answer=0;
    static int[] arr;
    public int solution(int[] numbers, int target) {
        len = numbers.length;
        T = target;
        arr = numbers.clone();
        
        DFS(0,0);
        
        return answer;
    }
    
    static void DFS(int sum, int cnt){
        if(cnt>= len){
            if(sum == T) answer++;
            return;
        }
        
        DFS(sum-arr[cnt], cnt+1);
        DFS(sum+arr[cnt], cnt+1);
    }
}