//이전세대를 역순으로 조사하면서 방향정보를 1씩 더해주고 뒤에 붙이면 다음 세대가 나옴
//격자 크기는 x,y 범위 생각해봤을때 최소 100X100 
//드래곤커브는 격자를 벗어날 수 없음
#include<iostream>
#include<vector>
#include<cstring>
using namespace std;

int N,x,y,d,g;

int Map[110][110];
int dx[]{ 0,-1,0,1 };
int dy[]{ 1,0,-1,0 };

vector<int> dir;

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);

	cin >> N;

	for (auto i = 0; i < N; ++i) {
		dir.clear();
		cin >> y >> x >> d >> g;
		dir.push_back(d);

		Map[x][y] = 1;
		x += dx[d];
		y += dy[d];
		Map[x][y] = 1;

		for (auto j = 0; j < g; ++j) {
			int num = dir.size();
			for (auto s = num-1; s >= 0; --s) {
				int tmp_dir = (dir[s] + 1) % 4;
				x += dx[tmp_dir];
				y += dy[tmp_dir];
				Map[x][y] = 1;
				dir.push_back(tmp_dir);
			}
		}
	}

	int cnt = 0;
	for (auto i = 0; i < 110; ++i) {
		for (auto j = 0; j < 110; ++j) {
			if (Map[i][j] == 1 && Map[i + 1][j] == 1 && Map[i + 1][j + 1] == 1 && Map[i][j + 1] == 1)
				cnt++;
		}
	}

	cout << cnt;

	return 0;
}