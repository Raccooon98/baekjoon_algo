//백트래킹으로 명단 만들어가면서 능력치 총합의 최대값 저장하기?

//반례는 찾았음 처음에 무조건 0번 선수를 가지고 들어가서 0번 포지션에 여러 선수가 적합할 경우 뻑이 나는거였음
#include <iostream>
#include<algorithm>
#include<vector>
#include<cstring>
using namespace std;

int arr[11][11];
bool vis[11][11];
int squad[11];
int ans;

//가지치기를 해야하는데 선수를 뽑으면 그 선수는 싹 다 방문처리 해서 안뽑게?
void DFS(int idx,int p, int sum) {
    if (idx == 11) {
        ans = max(ans, sum);
        return;
    }

    //부적합
    if (arr[p][idx] == 0)
        return;
    //뽑은 선수이면 건너뛰기?
    if (vis[p][idx] == true)
        return;
    
    sum += arr[p][idx];
    for (int i = 0; i < 11; ++i) {
        for (int j = 0; j < 11; ++j) {
            vis[p][j] = true;
        }
        DFS(idx + 1, i, sum);
        for (int j = 0; j < 11; ++j) {
            vis[p][j] = false;
        }
    }
}

int main()
{
    cin.tie(NULL)->sync_with_stdio(false);

    int T;
    cin >> T;
    for (int TC = 1; TC <= T; ++TC) {
        ans = 0;
        memset(vis, false, sizeof(vis));
        for (int i = 0; i < 11; ++i) {
            for (int j = 0; j < 11; ++j) {
                cin >> arr[i][j];
            }
        }

        for (int i = 0; i < 11; ++i) {
            DFS(0, i, 0);
        }

        cout << ans << '\n';
    }
}