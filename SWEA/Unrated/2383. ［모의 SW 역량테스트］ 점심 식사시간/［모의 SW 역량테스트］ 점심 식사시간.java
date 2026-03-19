import java.io.*;
import java.util.*;

public class Solution {
    static int N, minTime;
    static ArrayList<Person> pList;
    static ArrayList<Stair> sList;
    static int[] selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine().trim());
            pList = new ArrayList<>();
            sList = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int val = Integer.parseInt(st.nextToken());
                    if (val == 1) pList.add(new Person(i, j));
                    else if (val > 1) sList.add(new Stair(i, j, val));
                }
            }

            selected = new int[pList.size()];
            minTime = Integer.MAX_VALUE;

            divide(0);

            System.out.println("#" + t + " " + minTime);
        }
    }

    static void divide(int idx) {
        if (idx == pList.size()) {
            minTime = Math.min(minTime, calculate());
            return;
        }

        selected[idx] = 0;
        divide(idx + 1);

        selected[idx] = 1;
        divide(idx + 1);
    }

    static int calculate() {
        int maxFinishTime = 0;

        for (int sIdx = 0; sIdx < 2; sIdx++) {
            Stair s = sList.get(sIdx);
            PriorityQueue<Integer> arrivalTimes = new PriorityQueue<>();

            for (int i = 0; i < pList.size(); i++) {
                if (selected[i] == sIdx) {
                    int dist = Math.abs(pList.get(i).x - s.x) + Math.abs(pList.get(i).y - s.y);
                    arrivalTimes.add(dist + 1);
                }
            }

            if (arrivalTimes.isEmpty()) continue;

            Queue<Integer> stairQ = new LinkedList<>();
            int lastPersonOut = 0;

            while (!arrivalTimes.isEmpty()) {
                int arrival = arrivalTimes.poll();

                if (stairQ.size() == 3) {
                    int firstOut = stairQ.poll();
                    int entryTime = Math.max(arrival, firstOut);
                    lastPersonOut = entryTime + s.len;
                } else {
                    lastPersonOut = arrival + s.len;
                }
                stairQ.add(lastPersonOut);
            }

            maxFinishTime = Math.max(maxFinishTime, lastPersonOut);
        }

        return maxFinishTime;
    }

    static class Person {
        int x, y;
        public Person(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Stair {
        int x, y, len;
        public Stair(int x, int y, int len) {
            this.x = x;
            this.y = y;
            this.len = len;
        }
    }
}