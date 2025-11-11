import java.io.*;
import java.util.*;

class Solution {
    private static int[][] board;
    public int solution(int n, int w, int num) {
        
        int h = (n + w - 1) / w;
        board = new int[h][w];
        int flag = 1; // ㄹ자로 격자를 채우기 위해 1, -1 스위칭
        int number = 1;
        int x=0, y=0;
        
        for(int i=0;i<h;i++){
            if(flag == 1){
                for(int j = 0; j < w && number <= n; j++){
                    if(number == num){
                        x=i; y=j;
                    }
                    board[i][j] = number;
                    number++;
                }
                flag *= -1;
            }else{
                for(int j = w-1; j >= 0 && number <= n;j--){
                    if(number == num){
                        x=i; y=j;
                    }
                    board[i][j] = number;
                    number++;
                }
                
                flag *= -1;
            }
        }
        
        int answer = 0;
        
        for(int i=x;i<h;i++){
            if(board[i][y]!=0) answer++;
        }
        
        
        return answer;
    }
}