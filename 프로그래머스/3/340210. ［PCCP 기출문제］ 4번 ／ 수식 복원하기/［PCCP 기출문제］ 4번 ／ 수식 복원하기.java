import java.io.*;
import java.util.*;

class Solution {
    public String[] solution(String[] expressions) {
        ArrayList<String> answerList = new ArrayList<>();
        ArrayList<Integer> possibleBase = new ArrayList<>();
        
        for(int base=2; base<=9; base++){
            boolean checkBase = true;
            
            for( String s : expressions){
                StringTokenizer st =new StringTokenizer(s);
                String A = st.nextToken();
                String operator = st.nextToken();
                String B = st.nextToken();
                String equalText = st.nextToken();
                String C = st.nextToken();
                
                if(!isValidNum(A,base) || !isValidNum(B,base)){ //먼저 필터를 하지 않으면 parseInt(A,base) -> 에서 Exception 발생
                    checkBase = false;
                    break;
                }
                
                if(!C.equals("X")){
                    if(!isValidNum(C,base)){
                        checkBase = false;
                        break;
                    }
                    
                    int AA = Integer.parseInt(A,base);
                    int BB = Integer.parseInt(B,base);
                    int CC = Integer.parseInt(C,base);
                    
                    int result;
                    
                    if(operator.equals("+")){
                        result = AA + BB;
                    }else if(operator.equals("-")){
                        result = AA - BB;
                        if(result < 0 ){
                            checkBase =false;
                            break;
                        }
                    }else{
                        checkBase =false;
                        break;
                    }
                    
                    if(result != CC){
                        checkBase = false;
                        break;
                    }
                }
            }
            
            if(checkBase){
                possibleBase.add(base);
            }
            
        }
        
        for(String s : expressions){
            StringTokenizer st =new StringTokenizer(s);
            String A = st.nextToken();
            String operator = st.nextToken();
            String B = st.nextToken();
            String equalText = st.nextToken();
            String C = st.nextToken();
            
            if(C.equals("X")){
                Set<String> possibleResult = new HashSet<>();
                
                for(int base: possibleBase){
                    if(!isValidNum(A,base)||!isValidNum(B,base)) continue;
                    
                    int AA = Integer.parseInt(A,base);
                    int BB = Integer.parseInt(B,base);
                    int result;
                    if(operator.equals("+")){
                        result = AA + BB;
                    }else if(operator.equals("-")){
                        result = AA - BB;
                        if(result < 0) continue;
                    }else continue;
                    
                    String resultStr = Integer.toString(result,base).toUpperCase();
                    if(!isValidNum(resultStr,base)) continue;
                    
                    possibleResult.add(resultStr);
                }
                if(possibleResult.size()==1){
                    String val = possibleResult.iterator().next();
                    StringBuilder sb = new StringBuilder();
                    sb.append(A).append(" ").append(operator).append(" ").append(B).append(" = ").append(val);
                    answerList.add(sb.toString());
                }else{
                    StringBuilder sb = new StringBuilder();
                    sb.append(A).append(" ").append(operator).append(" ").append(B).append(" = ?");
                    answerList.add(sb.toString());
                }
            }
        }
        
        return answerList.toArray(new String[0]);
    }
    
    private static boolean isValidNum(String num, int base){
        for(int i=0;i<num.length(); i++){
            char c = num.charAt(i);
            if(c<'0'||c>'9'){
                return false;
            }
            int number = c-'0';
            if(number>=base){
                return false;
            }
        }
        return true;
    }
}