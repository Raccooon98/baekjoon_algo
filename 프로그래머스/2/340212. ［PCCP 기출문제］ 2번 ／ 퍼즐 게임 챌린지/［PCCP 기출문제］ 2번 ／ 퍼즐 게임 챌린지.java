import java.io.*;
import java.util.*;

class Solution {
    private static int n;
    private static int[] diff, time;
    private static long limitTime;
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        diff = diffs; time = times; limitTime = limit;
        n = diffs.length;
        
        int left = 1, right = 300000;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(check(mid)){
                answer = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        
        
        return answer;
    }
    
    private static boolean check(int level){
        long sum=0;
        for(int i = 0; i < n; i++){
            int prevTime = 0, curTime = time[i], difficulty = diff[i];
            if(i != 0){
                prevTime = time[i - 1];
            }
                       
            if(level >= difficulty){
                sum += curTime;
            }else{
                sum += (Math.abs(difficulty - level) * (curTime + prevTime) + curTime);
            }
        }
        if(sum > limitTime){
            return false;
        }else{
            return true;
        }
    }
}