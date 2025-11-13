//k가 10^12까지니까 단순 for문은 절대 안됨
//배열에 표시 하기도 안될듯 -> 비트마스킹?
//해시맵 써보기 -> 빈 방이면 바로 다음 방 번호를 value로 채워주기 포인터 느낌?
import java.io.*;
import java.util.*;

class Solution {
    private static Map<Long,Long> map = new HashMap<>();
    public long[] solution(long k, long[] room_number) {
        int n = room_number.length;
        long[] answer = new long[n];
        
        for(int i=0;i<n;i++){
            answer[i] = findRoom(room_number[i]);
        }
        
        return answer;
    }
    
    private static long findRoom(long room){
        if(!map.containsKey(room)){
            map.put(room, room + 1);
            return room;
        }
        
        long nextRoom = map.get(room);
        long emptyRoom = findRoom(nextRoom);
        map.put(room,emptyRoom);
        return emptyRoom;
    }
}