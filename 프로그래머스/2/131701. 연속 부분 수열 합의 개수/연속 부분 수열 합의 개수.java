import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] elements) {
        int len = elements.length;
        
        Set<Integer> set = new HashSet<>();
        
        for(int i=0;i<len;i++){
            int sum=0;
            for(int j=0;j<len;j++){
                sum+=elements[(i+j)%len];
                set.add(sum);
            }
        }
        return set.size();
    }
}