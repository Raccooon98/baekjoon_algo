//문자열 두개를 놓고 각 알파벳을 카운트 한담에 안겹치는 애들 싹 삭제하기
//카운트한 배열 두개 생성 배열 두개 그냥 마이너스 연산해서 절대값 만큼 cnt에 더해주기
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String str1,str2;
    static int[][]count = new int[2][26];
    public static void main(String[] args) throws IOException {
        str1=br.readLine();
        str2=br.readLine();

        for(char a:str1.toCharArray()){
            count[0][a-'a']++;
        }

        for(char b:str2.toCharArray()){
            count[1][b-'a']++;
        }

        int cnt=0;

        for(int i=0;i<26;++i){
            cnt+=Math.abs(count[0][i]-count[1][i]);
        }

        System.out.println(cnt);
    }
}
