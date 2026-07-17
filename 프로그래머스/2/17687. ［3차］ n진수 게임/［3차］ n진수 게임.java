import java.io.*;
import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        StringBuilder tmpString = new StringBuilder();
        int num=0;
        //m명이 t번 말할 정도는 만들기
        while(tmpString.length()<m*t){
            tmpString.append(Integer.toString(num,n).toUpperCase());
            num++;
        }
        
        StringBuilder tmp = new StringBuilder();
        for(int i=p-1;i<m*t;i+=m){
            tmp.append(tmpString.charAt(i));
        }
        
        return answer=tmp.toString();
    }
}