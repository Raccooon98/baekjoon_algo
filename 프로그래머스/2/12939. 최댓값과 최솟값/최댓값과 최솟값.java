import java.util.*;
import java.io.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        StringTokenizer st= new StringTokenizer(s);
        
        int[] arr= new int[st.countTokens()];
        
        int idx=0;
        while(st.hasMoreTokens()){
            arr[idx++] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        StringBuilder sb= new StringBuilder();
        sb.append(arr[0]+" ").append(arr[idx-1]);
        return sb.toString();
    }
}