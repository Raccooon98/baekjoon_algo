import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N,M,result;
    static int[] dx={0,1,0,-1};
    static int[] dy={1,0,-1,0};
    static int[][] Map;
    static int[][][] vis;
    static Queue<Coord> q;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();
        M=sc.nextInt();
        sc.nextLine();

        Map=new int[N][M];
        vis=new int[N][M][2];
        q=new LinkedList<>();
        for(int i=0;i<N;i++) {
            String s = sc.nextLine();
            for(int j=0;j<M;j++) {
                Map[i][j]=s.charAt(j)-'0';
            }
        }
        BFS();
        System.out.println(result);


    }

    static void BFS(){
        q.add(new Coord(0,0,1));
        vis[0][0][1]=1;

        while(!q.isEmpty()){
            Coord cur=q.poll();
            int cx=cur.x,cy=cur.y, canbreak=cur.canbreak;
            if(cur.x==N-1&&cur.y==M-1){
                result=vis[cx][cy][canbreak];
                return;
            }

            for(int i=0;i<4;i++){
                int nx=cx+dx[i];
                int ny=cy+dy[i];

                if(nx<0||ny<0||nx>=N||ny>=M)continue;
                if(Map[nx][ny]==1&&canbreak==1){
                    q.add(new Coord(nx,ny,0));
                    vis[nx][ny][canbreak-1]=vis[cx][cy][canbreak]+1;
                }
                else if(Map[nx][ny]==0&&vis[nx][ny][canbreak]==0){
                    q.add(new Coord(nx,ny,canbreak));
                    vis[nx][ny][canbreak]=vis[cx][cy][canbreak]+1;
                }
            }
        }
        result=-1;
    }

    static class Coord{
        int x, y,canbreak;
        public Coord(int x,int y,int canbreak){
            this.x=x; this.y=y; this.canbreak=canbreak;
        }
    }
}
