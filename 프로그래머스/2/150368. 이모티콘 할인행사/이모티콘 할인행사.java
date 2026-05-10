import java.io.*;
import java.util.*;

// 1<=M<=7 이고 1<=N<=100 기억하기

class Solution {
    static int[] saleRate = {10,20,30,40};
    static int N,M;
    static List<Emoticon> list = new ArrayList<>();
    static int[] answer = new int[2];
    static class Emoticon{
        int rate,price;
        
        public Emoticon(int rate,int price){
            this.rate=rate;
            this.price=price;
        }
    }
    
    public int[] solution(int[][] users, int[] emoticons) {
        
        N = users.length;
        M = emoticons.length;
        
        func(users,emoticons,0);
        return answer;
    }
    
    static void func(int[][] users,int[] emoticons, int depth){
        if(depth == M){
            int[] result = countUser(users);
            
            if(answer[0]<result[0]){
                answer = result.clone();
            }
            if(answer[0]==result[0]&&answer[1]<result[1]){
                answer = result.clone();
            }
            
            return;
        }
        
        for(int i=0;i<4;i++){
            int rate = saleRate[i];
            int discountedPrice = emoticons[depth]*(100-rate)/100;
            
            list.add(new Emoticon(rate,discountedPrice));
            func(users,emoticons,depth+1);
            list.remove(list.size()-1);
        }
    }
    
    static int[] countUser(int[][] users){
        int plusCount=0;
        int sum=0;
        
        for(int i=0;i<N;i++){
            int totalPrice=0;
            
            for(Emoticon e:list){
                if(users[i][0]<=e.rate){
                    totalPrice += e.price;
                }
            }
            
            if(totalPrice >= users[i][1]){
                plusCount++;
            }else{
                sum +=totalPrice;
            }
        }
        
        
        return new int[]{plusCount,sum};
    }
    
}