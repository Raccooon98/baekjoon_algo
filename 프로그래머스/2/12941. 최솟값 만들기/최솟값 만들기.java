import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);
        B = orderReverse(B);
        
        for(int i=0;i<A.length;i++){
            answer += A[i]*B[i];
        }

        return answer;
    }
    
    
    static int[] orderReverse(int[] arr){
        int len = arr.length;
        int[] temp =new int[len];
        for(int i=0;i<len;i++){
            temp[i] = arr[len-1-i];
        }
        
        return temp;
    }
}