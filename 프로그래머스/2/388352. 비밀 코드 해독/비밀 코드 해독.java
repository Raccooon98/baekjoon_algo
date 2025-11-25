//1~n 까지 중에서 5가지를 조합으로 고르는 조합으로 전부 생석하고
//q 랑 교집합이 ans 랑 동일하게 나오면 count++
import java.io.*;
import java.util.*;

class Solution {
    static Set<Integer>[] set;
    static int answer = 0;
    static boolean[] vis;
    static int[] arr = new int[5];
    
    public int solution(int n, int[][] q, int[] ans) {
        set = new HashSet[q.length];
        for(int i=0; i < q.length; i++){
            set[i] = new HashSet<>();
            for(int j = 0; j < 5; j++){
                set[i].add(q[i][j]);
            }
        }
        
        vis = new boolean[n+1];
        makeArr(0, 1, n, q, ans);
        
        return answer;
    }
    
    static void makeArr(int idx, int cur, int n, int[][] q, int[] ans){
        if(idx == 5){
            if(isValid(q,ans)){
                answer++;
            }
            return;
        }
        
        for(int i = cur; i <= n; i++){
            if(vis[i]) continue;
            
            arr[idx] = i;
            vis[i] = true;
            makeArr(idx + 1, i+1, n, q, ans);
            vis[i] = false;
        }
    }
    
    static boolean isValid(int[][] q, int[] ans){
        for(int i = 0; i < q.length; i++){
            int cnt = 0;
            
            for(int n : arr){
                if(set[i].contains(n)){
                    cnt++;
                }
            }
            
            if(ans[i] != cnt)
                return false;
        }
        
        return true;
    }
}