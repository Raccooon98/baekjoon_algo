//장애물을 3개 세워서 다 피할수 있는지 확인하기
//백트래킹 노가다?
#include <iostream>
#include<algorithm>
#include<vector>
using namespace std;

const int INF = 1000000000;

char arr[6][6];
int dx[] = { 0,1,0,-1 };
int dy[] = { 1,0,-1,0 };
vector< pair<int, int>>  e, t;
int N;

bool check(int x, int y) {
    for (int i = 0; i < 4; ++i) {
        int nx = x;
        int ny = y;

        while (nx >= 0 && ny >= 0 && nx < N && ny < N) {
            if (arr[nx][ny] == 'O')break;
            if (arr[nx][ny] == 'S')return false;
            nx += dx[i];
            ny += dy[i];
        }
    }
    return true;
}

void DFS(int cnt, int idx) {


    if (cnt == 3) {
        for (auto x : t) {
            if (!check(x.first, x.second))
                return;
        }
        //다 막히면
        cout << "YES\n";
        exit(0);
    }

    for (int i = idx; i < e.size(); ++i) {
        arr[e[i].first][e[i].second] = 'O';
        DFS(cnt + 1, i + 1);
        arr[e[i].first][e[i].second] = 'X';
    }
}

int main(void)
{
    cin.tie(NULL)->sync_with_stdio(false);

    cin >> N;

    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < N; ++j) {
            cin >> arr[i][j];

            if (arr[i][j] == 'T') {
                t.push_back({ i,j });
            }
            else if (arr[i][j] == 'X') {
                e.push_back({ i,j });
            }
        }
    }



    DFS(0, 0);//DFS안에서 종료가 안되면 NO 출력
    cout << "NO\n";
    return 0;
}