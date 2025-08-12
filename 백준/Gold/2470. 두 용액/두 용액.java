//이분탐색? 투포인터?
//양끝 중에 하나 정하고 이분탐색으로 0과 가까워질 수 있는지 결정하기?
import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int arr[];
    public static void main(String []args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st =new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); //왼쪽이 음수 오른쪽이 양수

        int check = Integer.MAX_VALUE;
        int ans1=0, ans2=0;
        int left=0, right=N-1;

        while(left<right){
            int sum = arr[left]+arr[right];

            if(Math.abs(sum)<check){
                check = Math.abs(sum);
                ans1 = arr[left];
                ans2 = arr[right];
            }

            if(sum<0){//음수를 양수에 가깝게
                left++;
            }else{//양수를 음수에 가깝게
                right--;
            }
        }

        System.out.println(ans1+" "+ans2);
    }
}
