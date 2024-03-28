#include<iostream>
#include<vector>
#include<queue>
#include<algorithm>
using namespace std;

struct Cube {
	int z, x, y;
};
int MAX = 130;
int result;
int dx[] = { 1,0,-1,0,0,0 };
int dy[] = { 0,-1,0,1,0,0 };
int dz[] = { 0,0,0,0,1,-1 };
int Floor[5] = { 0,1,2,3,4 };
bool maze[5][5][5] = { 0, };

void rotate(int z) {//한층을 90도 회전
	int tmp[5][5];
	for (auto i = 0; i < 5; ++i)
		for (auto j = 0; j < 5; ++j)
			tmp[i][j] = maze[z][i][j];

	for (auto i = 0; i < 5; ++i)
		for (auto j = 0; j < 5; ++j)
			maze[z][j][4 - i] = tmp[i][j];
}

int BFS() {
	if (!(maze[Floor[0]][0][0] && maze[Floor[4]][4][4]))
		return MAX;

	bool vis[5][5][5]{ 0 };
	vis[0][0][0] = 1;
	queue<Cube> q;
	q.push({ 0,0,0 });
	int d = 0;

	while (!(q.empty() || vis[4][4][4])) {
		d++;
		for (auto i = q.size(); i--;) {
			Cube cur = q.front();
			q.pop();

			for (auto dir = 0; dir < 6; ++dir) {
				int nz = cur.z + dz[dir];
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];

				if (nz < 0 || nz >= 5 || nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
				if (vis[nz][nx][ny])continue;
				if (!maze[Floor[nz]][nx][ny]) continue;
				vis[nz][nx][ny] = 1;
				q.push({ nz,nx,ny });
			}
		}
	}
	if (vis[4][4][4])
		return d;
	else
		return MAX;
}

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);

	for (auto h = 0; h < 5; ++h) {
		for (auto j = 0; j < 5; ++j) {
			for (auto i = 0; i < 5; ++i) {
				cin >> maze[h][j][i];
			}
		}
	}
	result = MAX;
	 
	for (int a = 0; a < 1024; a++) {//돌리는 방법은 4X4X4X4X4라서 1024가지이다. 감시문제에서 했던것 처럼 돌리는것을
		int dir[5];
		int tmp = a;
		for (int s = 0; s < 5; s++) {
			dir[s] = tmp % 4; // 회전 정보를 0부터 3까지의 숫자로
			tmp /= 4;
		}
		for (auto s = 0; s < 5; ++s) {
			for (auto i = 0; i < dir[s]; ++i) {
				rotate(s);//회전시키기
			}
		}

		do {
			result = min(result, BFS());//자기자신과 비교
		} while (next_permutation(Floor, Floor + 5));//5개 층 쌓기 ->5! = 120가지 순열

		for (auto s = 0; s < 5; ++s) {
			for (auto i = 0;dir[s] && i < 4- dir[s]; ++i) {
				rotate(s);//회전한것 원상복구 시키기
			}
		}
	}

	if (result == MAX)
		cout << -1;
	else
		cout << result;
}