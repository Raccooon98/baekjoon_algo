import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String target = "UCPC";
        boolean isUCPC=true;

        int idx = 0;

        for(char c : str.toCharArray()){
            if(idx<target.length()&&target.charAt(idx)==c){
                idx++;
            }
        }

        if(idx==target.length())
            isUCPC=true;
        else
            isUCPC=false;

        if(isUCPC){
            System.out.println("I love UCPC");
        }else{
            System.out.println("I hate UCPC");
        }

    }
}
