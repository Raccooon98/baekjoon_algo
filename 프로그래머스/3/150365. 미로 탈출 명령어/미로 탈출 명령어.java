import java.io.*;
import java.util.*;

class Solution {
    private static int N, M, X, Y, R, C, K;
    private static int[] dx = { 1, 0, 0, -1};//l,r,u,d
    private static int[] dy = { 0, -1, 1, 0};//좌우상하
    private static char[] d = {'d', 'l','r','u'};
    private static String answer = null;
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        N = n; M = m; X = x; Y = y; R = r; C = c; K = k;        

        if((Math.abs(X-R) + Math.abs(Y-C)) % 2 != k%2){
            return "impossible";
        }
        
        if(Math.abs(x-r)+Math.abs(y-c)>k){
            return "impossible";
        }
        
        DFS(X, Y, new StringBuffer(""));
        
        
        return answer;
    }
    
    private static void DFS(int x, int y, StringBuffer s){
        
        if(answer != null) return;
        
        if(s.length() == K && x == R && y == C) {
            answer = s.toString();
            return;
        } else if(s.length() == K) 
            return;
        
        int dist = Math.abs(x-R)+Math.abs(y-C);
        if(K-s.length() < dist)
            return;
        
        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            
            if(nx<1||nx>N||ny<1||ny>M) continue;
            
            s.append(d[i]);
            DFS(nx, ny, s);
            s.delete(s.length()-1, s.length());
        }
    }
}