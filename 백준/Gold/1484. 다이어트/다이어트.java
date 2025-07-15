//투포인터로 두 수 연산해서 비교하기?? end랑 직전값의 연산결과가 G이상이면 더이상 진행 X
import java.io.*;
import java.util.*;

public class Main{
    static int G;
    public static void main(String[] args)throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        G = Integer.parseInt(br.readLine());

        ArrayList<Integer> answer = new ArrayList<>();
        int now=2;
        int before=1;

        while(now>before){
            int diff = now*now - before*before;

            if(diff ==G){
                answer.add(now);
                before++;
            }else if(diff<G){
                now++;
            }else{
                before++;
            }

            if(now-before==1&&now*now-before*before>G&&before>0) break;
        }

        if(answer.isEmpty())
            System.out.println(-1);
        else{
            Collections.sort(answer);
            for(int num:answer){
                System.out.println(num);
            }
        }
        br.close();
    }

}
