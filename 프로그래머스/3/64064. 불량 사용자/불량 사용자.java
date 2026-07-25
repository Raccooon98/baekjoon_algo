import java.io.*;
import java.util.*;

class Solution {
    static String[] userId;
    static String[] bannedId;
    
    static HashSet<HashSet<String>> result = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        userId = user_id;
        bannedId=banned_id;
        
        DFS(new HashSet<>(),0);
        
        return result.size();
    }
    
    static void DFS(HashSet<String> set, int depth){
        if(depth==bannedId.length){
            result.add(new HashSet<>(set));
            return;
        }
        
        for(int i=0;i<userId.length;i++){
            if(set.contains(userId[i])) continue;
            
            if(isMatched(userId[i],bannedId[depth])){
                set.add(userId[i]);
                DFS(set,depth+1);
                set.remove(userId[i]);
            }
        }
    }
    
    static boolean isMatched(String user,String banned){
        
        if(user.length()!=banned.length()) return false;
        
        for(int i=0;i<user.length();i++){
            if(banned.charAt(i) != '*' && user.charAt(i)!=banned.charAt(i)){
                return false;
            }
        }
        
        return true;
    }
}