import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<String> word;
    static Map<String,Integer> wordMap= new HashMap<>();

    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        StringBuilder sb =new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++){
            String s = br.readLine();
            if(s.length()<M) continue;
            wordMap.put(s,wordMap.getOrDefault(s,0)+1);
        }

        word = new ArrayList<>(wordMap.keySet());
        Collections.sort(word,new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                int freq1 = wordMap.get(s1);
                int freq2 = wordMap.get(s2);
                if(freq1!=freq2){
                    return freq2-freq1;
                }

                if(s1.length()!=s2.length()){
                    return s2.length() - s1.length();
                }

                return s1.compareTo(s2);
            }

        });


        for(String s:word){
            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }
}
