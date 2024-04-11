#include<iostream>
#include<algorithm>
#include<queue>
#include<vector>
#include<cstring>
#include<tuple>
using namespace std;

int N, M, result;;
int Map[11][11];
int vis[11][11];
int parent[7];// 2<=섬<=6

int dx[]{ 1,-1,0,0 };
int dy[]{ 0,0,1,-1 };

vector<tuple<int, int, int> > bridge;
vector<pair<int, int> > v;

int find(int a)
{
	if (parent[a] == a)
		return a;
	return parent[a] = find(parent[a]);
}

void Union(int a, int b)
{
	a = find(a);
	b = find(b);
	if (a != b)
	{
		if (a < b)
			parent[b] = a;
		else
			parent[a] = b;
	}

}

bool sameParent(int a, int b)
{
	a = find(a);
	b = find(b);
	if (a != b)
		return false;
	return true;

}
//각 섬에 번호 매기기
void count_island(int x, int y, int num) {
	queue<pair<int, int>> q;
	q.push({ x,y });
	vis[x][y] = 1;
	Map[x][y] = num;

	while (!q.empty()) {
		auto [cx,cy] = q.front();
		q.pop();

		for (auto i = 0; i < 4; ++i) {
			int nx = cx + dx[i];
			int ny = cy + dy[i];

			if (nx < 0 || nx >= N || ny < 0 || ny >= M)continue;
			if (!vis[nx][ny] && Map[nx][ny] == -1) {
				vis[nx][ny] = 1;
				Map[nx][ny] = num;
				q.push({ nx,ny });
			}
		}
	}
}

//입력받은 방향대로 다리 만들기
void make_bridge(int x, int y, int dir) {
	int len = 0;
	int start_point = Map[x][y];

	while (1) {
		int nx = x + dx[dir];
		int ny = y + dy[dir];

		if (!(nx < 0 || ny < 0 || nx >= N || ny >= M)) {
			if (Map[nx][ny] == 0) {
				x = nx;
				y = ny;
				len++;
			}
			//길이가 2 이상이어야해서 조건 추가
			else if (len >= 2 && start_point != Map[nx][ny]) {
				bridge.push_back({ len,start_point,Map[nx][ny] });
				break;
			}
			else
				break;
			
		}
		else
			break;
		

	}
}


int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);

	cin >> N >> M;
	for (int i = 0; i < N; ++i) {
		for (int j = 0; j < M; ++j) {
			cin >> Map[i][j];
			if (Map[i][j] == 1) {
				Map[i][j] = -1;
				v.push_back({ i,j });
			}
		}
	}

	int cnt = 1;
	for (int i = 0; i < N; ++i) {
		for (int j = 0; j < M; ++j) {
			if (Map[i][j] == -1 && !vis[i][j]) {
				count_island(i, j, cnt);
				cnt++;
			}
		}
	}

	for (auto& [x, y] : v) {
		for (int i = 0; i < 4; ++i)
			make_bridge(x, y, i);
	}

	sort(bridge.begin(), bridge.end());

	for (int i = 1; i <= cnt; ++i) // union-find 알고리즘을 위해 초기화
		parent[i] = i;

	for (auto& [len, start, dest] : bridge) {
		if (!sameParent(start, dest)) {
			Union(start, dest);
			result += len;
		}
	}

	for (int i = 1; i < cnt; ++i) {
		if (find(i) != 1) {
			cout << -1;
			return 0;
		}
	}

	cout << result;
	return 0;
}
