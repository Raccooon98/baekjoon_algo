import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int count = 0;
        int len = people.length;
        Arrays.sort(people);
        int left=0;
        int right = len-1;
        
        while(left<=right){
            if(people[left]+people[right]<=limit){
                left++;
                right--;
                count++;
            }else{
                count++;
                right--;
            }
        }
        
        return count;
    }
}