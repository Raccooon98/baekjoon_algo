//최소공배수 = (N*M)/N과M의 최대 공약수
import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        int len = arr.length;
        Arrays.sort(arr);
        
        for(int i=0;i<len-1;i++){
            int temp = func(arr[i+1],arr[i]);
            arr[i+1] = (arr[i]*arr[i+1])/temp;
        }
        
        return arr[len-1];
    }
    
    static int func(int a,int b){
        if(a%b==0){
            return b;
        }
        return func(b,a%b);
    }
}