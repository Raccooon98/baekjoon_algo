import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String convertedNum= Integer.toString(n,k);
        StringBuilder sb= new StringBuilder();
        
        for(char c: convertedNum.toCharArray()){
            if(c=='0'){
                if(sb.length()>0){
                    long temp = Long.parseLong(sb.toString());
                    if(isPrime(temp)) answer++;
                    sb.setLength(0);
                }
            }else{
                sb.append(c);
            }
        }
        
        if(sb.length()>0){
            long temp = Long.parseLong(sb.toString());
                    if(isPrime(temp)) answer++;
                    sb.setLength(0);
        }
        
        return answer;
    }
    public static boolean isPrime(long n){
        if(n<2) return false;
        for(long i=2;i*i<=n;i++){
            if(n%i == 0) return false;
        }
        
        return true;
    }
    
}