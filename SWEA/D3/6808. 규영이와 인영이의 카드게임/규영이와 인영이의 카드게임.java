import java.io.*;
import java.util.*;

class Solution
{
	private static int[] gDeck, iDeck, tempDeck;
    private static boolean[] vis;
    private static int win, lose;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {

            gDeck = new int[9];
            iDeck = new int[9];
            tempDeck = new int[9];
            vis = new boolean[9];
            boolean[] check = new boolean[19];
            win = 0;
            lose = 0;


            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 9; i++) {
                gDeck[i] = Integer.parseInt(st.nextToken());
                check[gDeck[i]] = true;
            }

            int idx = 0;
            for (int i = 1; i <= 18; i++) {
                if (!check[i]) {
                    iDeck[idx++] = i;
                }
            }

            DFS(0);

            sb.append("#").append(t).append(" ").append(win).append(" ").append(lose).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void DFS(int depth) {
        if (depth >= 9) {
            int gPoint = 0;
            int iPoint = 0;
            for (int i = 0; i < 9; i++) {
                if (gDeck[i] > tempDeck[i]) {
                    gPoint += gDeck[i] + tempDeck[i];
                } else if(gDeck[i] < tempDeck[i]) {
                    iPoint += gDeck[i] + tempDeck[i];
                }
            }

            if (gPoint > iPoint) {
                win++;
            } else if(gPoint < iPoint) {
                lose++;
            }

            return;
        }

        for (int i = 0; i < 9; i++) {
            if (vis[i]) continue;
            vis[i] = true;
            tempDeck[depth] = iDeck[i];
            DFS(depth + 1);
            vis[i] = false;
        }
    }
}