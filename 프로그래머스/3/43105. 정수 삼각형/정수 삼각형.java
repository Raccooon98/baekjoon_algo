import java.io.*;
import java.util.*;

// class Solution {
//     static int[][] arr;
//     static int len;
//     static int max=0;
    
//     public int solution(int[][] triangle) {
//         len = triangle.length;
        
//         arr=triangle.clone();
        
//         DFS(arr[0][0],0,0);
        
//         return max;
//     }
    
//     static void DFS(int sum, int idx, int depth){
//         if(depth>=len-1){
//             max = Math.max(max,sum);
//             return;
//         }
        
//         DFS(sum+arr[depth+1][idx],idx,depth+1);
//         DFS(sum+arr[depth+1][idx+1],idx+1,depth+1);
//     }
// }


class Solution {
    static int memo[][];
    static int len;
    
    public int solution(int[][] triangle){
        len = triangle.length;
        memo = new int[len][len];
        
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                memo[i][j] = -1;
            }
        }
        
        return DFS(triangle, 0,0);
    }
    
    static int DFS(int[][]triangle, int depth, int idx){
        if(depth == len - 1){
            return triangle[depth][idx];
        }
        
        if(memo[depth][idx]!=-1){
            return memo[depth][idx];
        }
        
        memo[depth][idx] = triangle[depth][idx] + Math.max(
            DFS(triangle, depth+1,idx),
            DFS(triangle, depth+1,idx+1)
        );
        
        return memo[depth][idx];
    }
}