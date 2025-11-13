import java.io.*;
import java.util.*;

class Solution {
    public int solution(int k, int n, int[][] reqs) {
        int answer = 0;
        
        //각 타입별로 요청을 분리하기 위한 이중리스트
        List<List<Time>>timeByType = new ArrayList<>();
        for(int i=0;i<k+1;i++){
            timeByType.add(new ArrayList<>());
        }
        
        for(int[] req: reqs){
            int start = req[0];
            int duration = req[1];
            int type = req[2];
            
            timeByType.get(type).add(new Time(start, start+duration));
        }
        
        //각 유형의 상담사 수 별로 걸리는 대기시간 구해서 저장하기
        int[][] waitTimeByType = new int[k+1][n+1];
        for(int type = 1; type < k + 1; type++){
            if(timeByType.get(type).size()==0) continue; //해당 타입 신청자가 없을때 pass
            
            //각 타입 갯수k 만큼의 상담사가 무조건 필요하기 때문에 n-k 는 보장
            for(int mentor = 1; mentor <= (n - k) + 1; mentor++){
                
                int waitTime = calculateTime(timeByType.get(type), mentor);
                waitTimeByType[type][mentor] = waitTime;
            }
        }
        
        //타입별로 멘토 1명씩 채우기 일단
        int[] mentors = new int[k+1];
        for(int i = 1; i < k + 1; i++){
            mentors[i] = 1;
        }
        
        //남은 멘토 수
        int extraMentors = n-k;
        
        //멘토를 한명씩 채우면서 가장 많이 대기시간이 줄어드는 곳으로 배치
        while(extraMentors-- > 0){
            int maxReduceTime = 0;
            int maxReducetype = 0;
            
            for(int type = 1; type < k + 1; type++){
                
                int curMentorNum = mentors[type];//현재 상담원 수
                int curWaitTime = waitTimeByType[type][curMentorNum];//현재 인원으로의 대기시간
                int nextWaitTime = waitTimeByType[type][curMentorNum+1];//한명 늘렸을 때 대기시간
                int diff = curWaitTime - nextWaitTime;//차이
                
                if(diff >= maxReduceTime){
                    maxReduceTime = diff;
                    maxReducetype = type;
                }
            }
            
            if(maxReduceTime == 0) break;
            
            mentors[maxReducetype]++;
        }
        
        
        for(int type=1;type<k+1;type++){
            
            if(timeByType.get(type).size()==0) continue;
            
            answer += waitTimeByType[type][mentors[type]];
        }
        
        return answer;
    }
    
    //타입별로 멘토 수에 따라 대기시간 계산하는 함수
    private static int calculateTime(List<Time> list, int mentornum){
        int waitTime =0; 
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(Time t:list){
            if(pq.isEmpty()||pq.size()<mentornum){
                pq.offer(t.end);
            }else{
                int nearestEndTime = pq.poll();
                
                if(t.start<nearestEndTime){
                    waitTime += (nearestEndTime - t.start);
                    //끝나는대로 바로 상담 시작 하니까 duration만 늘려서 추가하기
                    pq.offer(nearestEndTime + (t.end - t.start));
                }else{
                    pq.add(t.end);//가장 가까운 종료시간보다 뒤에 상담 요청이면 그냥 바로 넣기
                }
            }
        }
        
        return waitTime;
    }
    
    private static class Time{
        int start, end;
        
        public Time(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
}