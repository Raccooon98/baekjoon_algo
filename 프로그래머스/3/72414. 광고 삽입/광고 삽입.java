//이분탐색 하려했는데 log가 30만줄 까지 가능해서 누적합 해보기
//자바 자체에 시간을 변환하는 클래스가 있을 것 같음
import java.io.*;
import java.util.*;

class Solution {
    private static String answer = "";
    
    public String solution(String play_time, String adv_time, String[] logs) {
        
        int time_check[] = new int[360005]; //100시간이 최대
        
        int play = parseToInt(play_time);
        int adv = parseToInt(adv_time); 
        
        if(play_time.equals(adv_time)){
            return "00:00:00";
        }
        
        int N = logs.length;
        String schedule[][] =new String[N][2];
        for(int i=0;i<N;i++){
            schedule[i] = logs[i].split("-");
        }
        
        for(int i=0;i<N;i++){
            int start = parseToInt(schedule[i][0]);
            int end = parseToInt(schedule[i][1]);
            
            time_check[start]++;
            time_check[end]--;
        }
        
        for(int i=1;i<360005;i++){
            time_check[i]+=time_check[i-1];
        }
        
        long max=0;
        long cur = max;
        int start_time=0;
        
        for(int i=adv;i<=play;i++){
            cur += time_check[i]-time_check[i-adv];
            if(cur>max){
                start_time=i-adv+1;
                max=cur;
            }
        }
        
        answer = parseToString(start_time);
        
        return answer;
    }
    //초 단위로 변환해 주는 함수
    private static int parseToInt(String time){
        int result = 0;
        String[] times = time.split(":");
        
        result += Integer.parseInt(times[0]) * 3600;
        result += Integer.parseInt(times[1]) * 60;
        result += Integer.parseInt(times[2]);
        
        return result;
    }
    
    //초로 표현되어있는 시간을 시간 포맷으로 바꿔주는 함수
    private static String parseToString(int time){
        StringBuilder sb = new StringBuilder();
        
        int hr = time / 3600;
        int min = (time % 3600) / 60;
        int sec = (time % 3600) % 60;
        
        if(hr<10) sb.append(0);
        sb.append(hr).append(":");
        
        if(min<10) sb.append(0);
        sb.append(min).append(":");
            
        if(sec<10) sb.append(0);
        sb.append(sec);
        
        return sb.toString();
    }
}