import java.io.*;
import java.util.*;

class Solution {
    static int [] parent;
    
    public int solution(int n, int[][] costs) {
        parent  = new int[n];
        Arrays.sort(costs, (a,b) -> Integer.compare(a[2],b[2]));
        for(int i=0;i<n;i++){
            parent[i] = i;
        }
        
        int count=0;
        int answer = 0;
        for(int[] cost:costs){
            int from = cost[0];
            int to = cost[1];
            int weight = cost[2];
            
            if(find(from)!=find(to)){
                union(from, to);
                answer += weight;
                count++;
            }
            
            if(count == n-1) break;
        }
        
        int len = costs.length;
        
        
        
        return answer;
    }
    
    static int find(int cur){
        if(parent[cur]==cur) return cur;
        return parent[cur] = find(parent[cur]);
    }
    
    static void union(int a,int b){
        int rootA = find(a);
        int rootB = find(b);
        
        if(rootA!=rootB){
            parent[rootB] = rootA;
        }
    }
}