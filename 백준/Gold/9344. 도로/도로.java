import java.util.*;

public class Main {
    static List<coord> list;
    static int[] parent;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //모든 도시??(p랑 q만 연결되면 됨)가 연결되면 되는 문제 ==> MST로 푸는게 맞는것 같음
        //시작점은 p로 잡고 q에 도달하면 빠져나오기?

        int TC=sc.nextInt();
        for(int T=1;T<=TC;++T){
            int N=sc.nextInt();
            int M=sc.nextInt();
            int p=sc.nextInt();
            int q=sc.nextInt();

            parent = new int[N+1];
            list =new LinkedList<>();
            for(int i=0;i<=N;++i){
                parent[i]=i;
            }

            for(int m=0;m<M;++m){
                int a=sc.nextInt();
                int b=sc.nextInt();
                int c=sc.nextInt();

                list.add(new coord(a,b,c));
            }

            Collections.sort(list,(o1,o2) -> {
                return o1.cost-o2.cost;
            });

            int cnt=1;
            boolean flag=false;
            for(coord li:list){
                if(union(li.start,li.to)){
                    cnt++;
                    if(p!=q&&(p==li.start||q==li.start)&&(p==li.to||q==li.to)){
                        flag=true;
                    }
                }
                if(cnt>=N)
                    break;
            }

            if(flag){
                System.out.println("YES");
                continue;
            }
            System.out.println("NO");
        }


    }

    static int find(int cur){
        if(cur ==parent[cur]){
            return cur;
        }
        return parent[cur] = find(parent[cur]);
    }

    static boolean union(int x,int y){
        int xparent=find(x);
        int yparent=find(y);
        if(xparent==yparent){
            return false;
        }
        parent[xparent] = yparent;
        return true;
    }

    static class coord{
        int start,to,cost;
        public coord(int start,int to,int cost){
            this.start = start;
            this.to=to;
            this.cost=cost;
        }
    }
}