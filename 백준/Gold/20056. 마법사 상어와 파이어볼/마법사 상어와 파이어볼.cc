#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int N, M, K;
int dx[] = {-1,-1,0,1,1,1,0,-1};//8방향 표시
int dy[] = {0,1,1,1,0,-1,-1,-1};

struct fireball {
    int x, y;
    int m, s, d;
};

vector< fireball> Map[51][51];
vector< fireball> balls;

//이동 맵 넘어가면 반대쪽에서 이동 마저 하는거 구현
void Move_fireball() {
    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < N; ++j) {
            Map[i][j].clear();
        }
    }

    for (int i = 0; i < balls.size(); ++i) {
        auto& [x,y,m,s,d] = balls[i];
        int move = s % N;
        int nx = x + dx[d] * move;
        int ny = y + dy[d] * move;
        
        if (nx >= N) nx -= N;
        if (nx < 0)nx += N;
        if (ny >= N)ny -= N;
        if (ny < 0)ny += N;
        Map[nx][ny].push_back({ nx,ny,m,s,d });
        x = nx;y = ny;
        
        
    }
}

//합치기
void Mix_fireball() {
    vector<fireball> temp;
    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < N; ++j) {
            if (Map[i][j].size() == 0)
                continue;
            if (Map[i][j].size() == 1) {
                temp.push_back(Map[i][j][0]);
                continue;
            }
            
            int mass = 0;
            int speed = 0;
            int cnt = Map[i][j].size();
            bool even = true;
            bool odd = true;

            for (int n = 0; n < Map[i][j].size(); ++n) {
                auto& [x, y, m, s, d] = Map[i][j][n];
                mass += m;
                speed += s;
                if (d % 2 == 0)
                    odd = false;
                else
                    even = false;
            }
            mass /= 5;
            speed /= cnt;

            if (mass == 0)continue;
            if (even == true || odd == true) {
                for (int k = 0; k < 8; k += 2) {
                    temp.push_back({ i,j,mass,speed,k });
                }
            }
            else {
                for (int k = 1; k < 8; k += 2) {
                    temp.push_back({ i,j,mass,speed,k });
                }
            }
        }
    }

    balls = temp;
}


int main(void)
{
    cin.tie(NULL)->sync_with_stdio(false);

    cin >> N >> M >> K;
    for (int i = 0; i < M; ++i) {
        int a, b, c, d, e;
        cin >> a >> b >> c >> d >> e;
        balls.push_back({a,b,c,d,e});
        Map[a][b].push_back({ a,b,c,d,e });


    }

    for (int i = 0; i < K; ++i) {
        Move_fireball();
        Mix_fireball();
    }

    int res = 0;
    
    for (int i = 0; i < balls.size(); ++i) {
        res += balls[i].m;
    }

    cout << res << '\n';

    return 0;
}