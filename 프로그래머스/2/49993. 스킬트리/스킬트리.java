import java.io.*;
import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Set<Character> set = new HashSet<>();
        Queue<Character> q = new ArrayDeque<>();
        
        for(char c: skill.toCharArray()){
            set.add(c);
        }
        
        for(String tree : skill_trees){
            for(char c: skill.toCharArray()){
                q.offer(c);
            }
            boolean flag = true;
            for(char c:tree.toCharArray()){
                if(set.contains(c)){
                    if(q.peek()!=c){
                        flag = false;
                        break;
                    }else q.poll();
                }
            }
            
            if(flag) answer++;
            q.clear();
        }
        
        
        return answer;
    }
}