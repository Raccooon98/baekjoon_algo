import java.io.*;
import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int len = puddles.length;
        int[][] board = new int[n][m];
        for(int i=0;i<len;i++){
            int cx = puddles[i][1]-1;
            int cy = puddles[i][0]-1;
            
            board[cx][cy] = -1;
        }
        
        for(int i=0;i<m;i++){
            if(board[0][i]==-1) break;
            
            board[0][i] = 1;
        }
        
        for(int i=0;i<n;i++){
            if(board[i][0]==-1) break;
            
            board[i][0] = 1;
        }
        
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(board[i][j]==-1) continue;
                long tmp=0;
                
                if(board[i-1][j]>0) tmp+=board[i-1][j];
                if(board[i][j-1]>0) tmp+=board[i][j-1];
                
                board[i][j] = (int)(tmp%1000000007);
            }
        }
        
        return board[n-1][m-1];
    }
}