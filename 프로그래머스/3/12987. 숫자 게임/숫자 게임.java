import java.io.*;
import java.util.*;

// class Solution {//A팀은 순서가 고정이라는 얘기 -> A팀 배치 보고 B가 무조건 이기게 배치 가능하니까 둘다 정렬해서 비교해도 문제 없음....
//     static int[] teamA, teamB;
//     static boolean[] vis;
//     static int len, max=0;
//     public int solution(int[] A, int[] B) {
//         int answer = -1;
//         teamA = A.clone();
//         teamB = B.clone();
//         len = A.length;
//         vis=new boolean[len];
//         int[] temp= new int[len];
        
//         DFS(0,temp);
        
//         return max;
//     }
    
//     static void DFS(int idx,int[] temp){
//         if(idx>=len-1){
//             int score = calScore(temp);
//             max = Math.max(max, score);
//             return;
//         }
        
//         for(int i=0;i<len;i++){
//             if(!vis[i]){
//                 vis[i] = true;
//                 temp[idx] = teamB[i];
//                 DFS(idx+1,temp);
//                 vis[i] = false;
//             }        
//         }
//     }
    
//     static int calScore(int[] temp){
//         int a=0, b=0;
        
//         for(int i=0;i<len;i++){
//             if(teamA[i]>temp[i]) 
//                 a++;
//             else if(teamA[i]<temp[i]) 
//                 b++;
//         }
        
//         return b;
//     }
// }

class Solution{
    public int solution(int[] A, int[] B){
        Arrays.sort(A);
        Arrays.sort(B);
        
        int aIdx =0, bIdx=0;
        int score=0;
        int len = A.length;
        
        while(bIdx<len){
            if(B[bIdx]>A[aIdx]){
                score++;
                aIdx++;
            }
            
            bIdx++;
        }
        
        return score;
    }
}