import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer=new int[2];
        int cnt=0;
        int sum=0;
        String str = s;
        
        while(!str.equals("1")){
            cnt++;
            StringBuilder sb=new StringBuilder();
            
            for(char c:str.toCharArray()){
               if(c=='1'){
                   sb.append(c);
                }else{
                    sum++;
                }
            }
            int len = sb.length();
            str = Integer.toBinaryString(len);

        }
        answer[0] = cnt;
        answer[1] = sum;
        
        return answer;
    }
}