import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        List<Integer> result = new ArrayList<>();
        Map<String, List<Record>> map = new TreeMap<>();
        int len = records.length;
        int defaultTime = fees[0], defaultFee = fees[1], standardTime = fees[2], standardFee = fees[3];
        
        StringTokenizer st;
        for(int i=0;i<len;i++){
            st=new StringTokenizer(records[i]);
            String time = st.nextToken();
            String carNo = st.nextToken();
            String status = st.nextToken();
            
            map.computeIfAbsent(carNo, k -> new ArrayList<>()).add(new Record(time, status));
        }
        
        for(String cur: map.keySet()){
            List<Record> temp = map.get(cur);
            String prevTime = null;
            int totalMin = 0;
            for(Record now:temp){
                if(now.status.equals("IN")){
                    prevTime = now.time;
                }else if(now.status.equals("OUT")){
                    totalMin += calDiff(prevTime, now.time);
                    prevTime = null;
                }
            }
            if(prevTime!=null){
                totalMin += calDiff(prevTime, "23:59");
            }
            
            if(totalMin<=defaultTime){
                result.add(defaultFee);
            }else{
                int fee = defaultFee+((int)Math.ceil((double)(totalMin-defaultTime)/standardTime))*standardFee;
                result.add(fee);
            }
        }
        int[] answer = result.stream().mapToInt(i->i).toArray();
        return answer;
    }
    static int calDiff(String prevTime,String nowTime){
        String[] s1 = prevTime.split(":");
        String[] s2 = nowTime.split(":");
                        
        int time1 = Integer.parseInt(s1[0])*60+Integer.parseInt(s1[1]);
        int time2 = Integer.parseInt(s2[0])*60+Integer.parseInt(s2[1]);
                        
        return time2-time1;
    }
    
    static class Record{
        String time;
        String status;
        
        public Record(String time, String status){
            this.time = time;
            this.status = status;
        }
    }
}