import java.io.*;
import java.util.*;

class Solution {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static boolean[][][] vis = new boolean[11][11][4];
    
    public int solution(String dirs) {
        int answer = 0;
        int x = 5, y=5;
        for(char c: dirs.toCharArray()){
            int dir = 0;
            if(c =='U') dir = 0;
            else if(c=='D') dir = 1;
            else if(c=='R') dir = 2;
            else if(c=='L') dir = 3;
            
            int nx = x+dx[dir];
            int ny = y+dy[dir];
            
            if(nx<0||nx>10||ny<0||ny>10) continue;
            
            if(!vis[x][y][dir]){
                vis[x][y][dir] = true;
                
                int reverseDir = (dir % 2 == 0) ? dir + 1 : dir - 1;
                vis[nx][ny][reverseDir] = true;
                
                answer++;
            }
            x=nx;
            y=ny;
        }
        
        return answer;
    }
}