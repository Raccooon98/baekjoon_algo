//이중for문 X 시간복잡도 터짐 -> 순회 한번으로 끝내기
import java.util.*;
import java.io.*;

public class Main{
    static int N, len=1;
    static int[] arr,LIS;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        LIS = new int[N];

        st = new StringTokenizer(br.readLine()," ");

        for(int i=0;i<N;++i){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        LIS[0]=arr[0];

        for(int i=0;i<N;++i){
            int num = arr[i];

            //만들어놓은 LIS맨 뒤 값이랑 현재 배열의 값 비교
            if(LIS[len-1]<num){
                len++;
                LIS[len-1]=num;
            } else{
                int start=0,end=len;
                while(start<end){
                    int mid = (start+end)/2;
                    if(LIS[mid]<num){
                        start=mid+1;
                    }else{
                        end=mid;
                    }
                }

                LIS[start]=num;
            }
        }

        System.out.println(len);
    }
}
