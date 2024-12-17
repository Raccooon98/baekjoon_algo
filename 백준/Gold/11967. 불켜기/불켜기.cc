#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

int N, M;
bool vis[105][105];
bool light[105][105];
vector<pair<int, int>> arr[105][105];
int dx[] = { 0, 1, 0, -1 };
int dy[] = { 1, 0, -1, 0 };

bool is_valid(int x, int y) {
    return x >= 1 && x <= N && y >= 1 && y <= N; // 격자 안인지 확인
}

int main(void) {
    cin.tie(NULL)->sync_with_stdio(false);
    cin >> N >> M;

    for (int i = 0; i < M; ++i) {
        int x1, y1, x2, y2;
        cin >> x1 >> y1 >> x2 >> y2;
        arr[x1][y1].emplace_back(x2, y2);
    }

    queue<pair<int, int>> q;
    vis[1][1] = true;  
    light[1][1] = true; 
    q.emplace(1, 1);

    int lit_rooms = 1; // 불이 켜진 방의 수

    while (!q.empty()) {
        auto [x, y] = q.front();
        q.pop();

        // 현재 방에서 켤 수 있는 불들을 켜기
        for (auto [nx, ny] : arr[x][y]) {
            if (!light[nx][ny]) {
                light[nx][ny] = true;
                lit_rooms++;

                for (int i = 0; i < 4; ++i) {
                    int tx = nx + dx[i];
                    int ty = ny + dy[i];
                    if (is_valid(tx, ty) && vis[tx][ty]) {
                        q.emplace(nx, ny);
                        vis[nx][ny] = true;
                        break;
                    }
                }
            }
        }

        // 현재 위치에서 이동 가능한 방으로 이동
        for (int i = 0; i < 4; ++i) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (is_valid(nx, ny) && light[nx][ny] && !vis[nx][ny]) {
                vis[nx][ny] = true;
                q.emplace(nx, ny);
            }
        }
    }

    cout << lit_rooms << '\n';
    return 0;
}
