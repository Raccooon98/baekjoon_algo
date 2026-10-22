import java.io.*;
import java.util.*;

class Solution {
    static int T;
    static int count=0;
    static int[] arr;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        arr = numbers.clone();
        T=target;
        
        func(0,0);
        
        return answer=count;
    }
    
    static void func(int idx, int sum){
        if(idx >= arr.length){
            if(sum == T){
                count++;
            }
            return;
        }
        
        func(idx+1,sum+arr[idx]);
        func(idx+1,sum-arr[idx]);
    }
}