#include<iostream>
#include<algorithm>
#include<queue>

using namespace std;
int R, C;
string board[1001];
int visj[1001][1001];//지훈이 방문 배열
int visf[1001][1001];//불 방문 배열
queue<pair<int, int>> jq;//지훈큐
queue<pair<int, int>> fq;//불큐

int dx[] = { 1,0,-1,0 };
int dy[] = { 0,1,0,-1 };


int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    cin >> R >> C;
    for (int i = 0; i < R; i++) {
        cin >> board[i];
    }
    for (int i = 0; i < R; i++) {
        fill(visj[i], visj[i] + C, -1);
        fill(visf[i], visf[i] + C, -1);
    }


    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            if (board[i][j] == 'J') {
                jq.push({ i,j });
                visj[i][j] = 0;
            }
            if (board[i][j] == 'F') {
                fq.push({ i,j });
                visf[i][j] = 0;
            }
        }
    }
    while (!fq.empty()) {
        int x = fq.front().first;
        int y = fq.front().second;
        fq.pop();
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;//지도 벗어나면 넘기기
            if (visf[nx][ny] >= 0 || board[nx][ny] == '#') continue;
            visf[nx][ny] = visf[x][y] + 1;
            fq.push({ nx,ny });
        }
    }

    while (!jq.empty()) {
        int x = jq.front().first;
        int y = jq.front().second;
        jq.pop();
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
                cout << visj[x][y] + 1;
                return 0;
            }
            if (visj[nx][ny] >= 0 || board[nx][ny] == '#') continue;
            if (visf[nx][ny] != -1 && visf[nx][ny] <= visj[x][y] + 1) continue;
            visj[nx][ny] = visj[x][y] + 1;
            jq.push({ nx,ny });
        }
    }
    cout << "IMPOSSIBLE";
}
