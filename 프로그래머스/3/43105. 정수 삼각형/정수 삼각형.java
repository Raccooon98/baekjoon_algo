import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int row = triangle.length;
        int col = triangle[row - 1].length;
        int[][] dp = new int[row][col];
        
        for(int i=row-1;i>=0;i--){
            dp[row-1][i] = triangle[row-1][i];
        }
        
        for(int i = row-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                dp[i][j] = Math.max(triangle[i][j]+dp[i+1][j],triangle[i][j]+dp[i+1][j+1]);
            }
        }
        
        return answer = dp[0][0];
    }
}