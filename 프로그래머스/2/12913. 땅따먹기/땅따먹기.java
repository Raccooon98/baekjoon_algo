import java.io.*;
import java.util.*;

class Solution {
    int solution(int[][] land) {
        int len = land.length;
    
        for(int i=1;i<len;i++){
            for(int j=0;j<4;j++){
                int prevMax =0;
                for(int k=0;k<4;k++){
                    if(j!=k){
                        prevMax = Math.max(prevMax, land[i-1][k]);
                    }
                }
                
                land[i][j] +=prevMax;
            }
        }
        int answer = Arrays.stream(land[len-1]).max().getAsInt();
        return answer;
    }
//     static void DFS(int[][] board, int sum, int depth){
//         if(depth==len){
//             answer = Math.max(answer, sum);        
//             return;
//         }
        
//         for(int i=0;i<4;i++){
//             if(checkX(depth) && checkY(i)){
//                 vis[depth][i] = true;
//                 DFS(board, sum+board[depth][i], depth+1);
//                 vis[depth][i] = false;
//             }
//         }
//     }
    
//     static boolean checkX(int x){
        
//         for(int i=0;i<4;i++){
//             if(vis[x][i]) return false;
//         }
        
//         return true;
//     }
    
//     static boolean checkY(int y){
//         for(int i=0; i < len; i++){
//             if(vis[i][y]) return false;
//         }
        
//         return true;
//     }
}