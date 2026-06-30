import java.io.*;
import java.util.*;

class Solution {
    static 
    
    public int solution(int[] people, int limit) {
        int answer = 0;
        int len = people.length;
        
        Arrays.sort(people);
        
        int left=0;
        int right=len-1;
        
        while(left<=right){
            if(people[left]+people[right]>limit){
                answer++;
                right--;
            }else{
                left++;
                right--;
                answer++;
            }
        }
        
        return answer;
    }
}