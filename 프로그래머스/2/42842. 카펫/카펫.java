import java.io.*;
import java.util.*;
//노란색이 1 이상이니까 무조건 3X3 이상 도형
class Solution {
    public int[] solution(int brown, int yellow) {//갈색 테두리, 노란색 속
        int[] answer =new int[2];
        
        int half = (brown+4)/2;
        int limit = half - half/2;
        int col=0;
        int row = half-col;
        
        
        for(col = 3; col <= limit; col++){
            row = half - col;
            
            if((row-2)*(col-2) == yellow){
                answer[0] = row;
                answer[1] = col;
                break;
            }
        }
        
        return answer;
    }
}