import java.io.*;
import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        if(!Arrays.asList(words).contains(target)) return 0;
        
        int len = words.length;
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(begin,0));
        boolean[] vis = new boolean[len];
        
        while(!q.isEmpty()){
            Node cur = q.poll();
            
            if(cur.word.equals(target)) return cur.count;
            
            for(int i=0;i<len;i++){
                if(!vis[i]&&canChange(cur.word, words[i])){
                    vis[i] = true;
                    q.offer(new Node(words[i],cur.count+1));
                }
            }
        }
        
        
        return 0;
    }
    
    
    static boolean canChange(String s1,String s2){
        int diff =0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)) diff++;
        }
        
        return diff == 1;
    }
    
    static class Node{
        String word;
        int count;
        
        public Node(String word, int count){
            this.word=word;
            this.count=count;
        }
    }
}