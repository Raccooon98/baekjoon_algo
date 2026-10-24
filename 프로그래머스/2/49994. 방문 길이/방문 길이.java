import java.io.*;
import java.util.*;

class Solution {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};
    
    public int solution(String dirs) {
        int answer = 0;
        int X = 5, Y = 5;
        Set<Integer>[][] board= new HashSet[11][11];
        Map<Character,Integer> map = new HashMap<>();
        map.put('U',0);
        map.put('D',1);
        map.put('R',2);
        map.put('L',3);
        
        for(int i=0;i<11;i++){
            for(int j=0;j<11;j++){
                board[i][j] = new HashSet<>();
            }
        }
        
        for(char c : dirs.toCharArray()){
            int dir = map.get(c);
            
            int nx = X+dx[dir];
            int ny = Y+dy[dir];
            
            if(nx<0||nx>=11||ny<0||ny>=11) continue;
            
            if(!board[nx][ny].contains(dir)) answer++;
            board[nx][ny].add(dir);
            board[X][Y].add(reverse_dir(dir));
            X = nx; Y = ny;
        }
        
        return answer;
    }
    static int reverse_dir(int dir){
        if(dir == 0) return 1;
        else if(dir == 1) return 0;
        else if(dir == 2) return 3;
        else return 2;
    }
}