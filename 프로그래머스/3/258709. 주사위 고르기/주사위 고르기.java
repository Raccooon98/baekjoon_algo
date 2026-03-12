import java.io.*;
import java.util.*;

class Solution {
    static int diceNum, size, maxWin;
    static boolean[] vis;
    static int[] answer;
    static int[][] globalDice;
    static List<Integer> sumA, sumB;
    
    public int[] solution(int[][] dice) {
        globalDice = dice;
        size = dice.length;
        diceNum = size / 2;
        answer = new int[diceNum];
        vis = new boolean[size];
        maxWin = -1;

        ArrayList<Integer> list = new ArrayList<>();
        pickDice(list, 0, 0);

        for (int i = 0; i < answer.length; i++) {
            answer[i]++;
        }
        
        return answer;
    }
    static void pickDice(ArrayList<Integer> list, int depth, int cur) {
        if (depth == diceNum) {
            int winCount = calWinRate(list);
            if (maxWin < winCount) {
                maxWin = winCount;
              
                for (int i = 0; i < list.size(); i++) {
                    answer[i] = list.get(i);
                }
            }
            return;
        }

        for (int i = cur; i < size; i++) {
            if (vis[i]) continue;
            vis[i] = true;
            list.add(i);
            pickDice(list, depth + 1, i + 1);
            list.remove(list.size() - 1);
            vis[i] = false;
        }
    }
    
    static int calWinRate(ArrayList<Integer> listA) {
        sumA = new ArrayList<>();
        sumB = new ArrayList<>();
        
        
        ArrayList<Integer> listB = new ArrayList<>();
        boolean[] isA = new boolean[size];
        for (int idx : listA) isA[idx] = true;
        for (int i = 0; i < size; i++) {
            if (!isA[i]) listB.add(i);
        }

        
        getSums(0, 0, listA, sumA);
        getSums(0, 0, listB, sumB);

        
        Collections.sort(sumB);

        int winCount = 0;
        for (int scoreA : sumA) {
            
            int left = 0;
            int right = sumB.size();
            while (left < right) {
                int mid = (left + right) / 2;
                if (sumB.get(mid) < scoreA) left = mid + 1;
                else right = mid;
            }
            winCount += left;
        }
        return winCount;
    }

    static void getSums(int depth, int sum, ArrayList<Integer> picked, List<Integer> totalSums) {
        if (depth == diceNum) {
            totalSums.add(sum);
            return;
        }
        for (int i = 0; i < 6; i++) {
            getSums(depth + 1, sum + globalDice[picked.get(depth)][i], picked, totalSums);
        }
    }
}