#include<queue>
#include<algorithm>
#include <iostream>
#include<cstring>
using namespace std;

int N, M;
bool check = false;
char arr[305][305];
bool vis[305][305];
int dx[] = { 0,1,0,-1 };
int dy[] = { 1, 0, -1, 0};

void BFS(int x, int y) {
    memset(vis, false, sizeof(vis));

    queue<pair<int, int>> q;
    q.push({ x,y });
    vis[x][y] = 1;

    while (!q.empty()) {
        auto [cx,cy] = q.front();
        q.pop();

        for (int i = 0; i < 4; ++i) {
            int nx = cx + dx[i];
            int ny = cy + dy[i];

            if (arr[nx][ny] == '#') {
                check = true;
                return;
            }

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if (vis[nx][ny]) continue;
                
            vis[nx][ny] = true;
            if (arr[nx][ny] == '1')arr[nx][ny] = '0';
            else if (arr[nx][ny] == '0')q.push({ nx,ny });


        }
    }
}

int main()
{
    cin.tie(NULL)->sync_with_stdio(false);
    int x1, x2, y1, y2;
    cin >> N >> M;
    cin >> x1 >> y1 >> x2 >> y2;
    x1--; x2--; y1--; y2--;
    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < M; ++j) {
            cin >> arr[i][j];
        }
    }

    int result = 0;
    while (1) {
        result++;
        BFS(x1, y1);
        if (check) break;
    }

    cout << result<<'\n';
    return 0;
}