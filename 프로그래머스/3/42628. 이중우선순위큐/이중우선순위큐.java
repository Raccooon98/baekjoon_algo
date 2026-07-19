import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        StringTokenizer st;
        TreeSet<Integer> tree = new TreeSet<>();
        
        for(String s:operations){
            st = new StringTokenizer(s);
            String order = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            
            if(order.equals("I")){
                tree.add(num);
            }else if(order.equals("D")){
                if(tree.isEmpty()) continue;
                if(num == 1){
                    tree.pollLast();
                }else if(num == -1){
                    tree.pollFirst();
                }
            }
            
        }
        int len = tree.size();
        if(len == 0) return new int[]{0,0};
        else return new int[]{tree.last(),tree.first()};
    }
}