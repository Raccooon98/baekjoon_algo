#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include<string>
using namespace std;

int dx[] = { 0, 1, 0, -1 };
int dy[] = { 1, 0, -1, 0 };
int N;
vector<string> board;

struct Coord {
	int x, y, dir;
};

bool is_inside(int x, int y) {
	return x >= 0 && x < N && y >= 0 && y < N && board[x][y] != '1';
}

bool can_rotate(int x, int y) {
	for (int i = -1; i <= 1; ++i) {
		for (int j = -1; j <= 1; ++j) {
			int nx = x + i, ny = y + j;

			if (!is_inside(nx, ny)) 
				return false;
		}
	}
	return true;
}

int bfs(Coord start, Coord end) {
	queue<pair<Coord, int>> q; //현재 통나무 상태랑 이동 횟수
	vector<vector<vector<bool>>> visited(N, vector<vector<bool>>(N, vector<bool>(2, false)));

	q.push({ start, 0 });
	visited[start.x][start.y][start.dir] = true;

	while (!q.empty()) {
		Coord cur = q.front().first;
		int moves = q.front().second;
		q.pop();

		if (cur.x == end.x && cur.y == end.y && cur.dir == end.dir) {
			return moves;
		}

		//이동
		for (int i = 0; i < 4; ++i) {
			int nx = cur.x + dx[i];
			int ny = cur.y + dy[i];

			bool valid = true;
			for (int j = -1; j <= 1; ++j) {
				int cx = nx + (cur.dir == 1 ? j : 0);
				int cy = ny + (cur.dir == 0 ? j : 0);
				if (!is_inside(cx, cy)) {
					valid = false;
					break;
				}
			}

			if (valid && !visited[nx][ny][cur.dir]) {
				visited[nx][ny][cur.dir] = true;
				q.push({ { nx, ny, cur.dir }, moves + 1 });
			}
		}

		// 회전
		if (can_rotate(cur.x, cur.y)) {
			int new_dir = 1 - cur.dir;
			if (!visited[cur.x][cur.y][new_dir]) {
				visited[cur.x][cur.y][new_dir] = true;
				q.push({ { cur.x, cur.y, new_dir }, moves + 1 });
			}
		}
	}

	return 0; // 목표 도달 불가능이면
}

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);

	cin >> N;
	board.resize(N);
	for (int i = 0; i < N; ++i) {
		cin >> board[i];
	}

	Coord start, end;
	bool is_start = false, is_end = false;

	for (int i = 0; i < N; ++i) {
		for (int j = 0; j < N; ++j) {
			if (board[i][j] == 'B' && !is_start) {
				if (i + 1 < N && board[i + 1][j] == 'B') {
					start = { i + 1, j, 1 };
				}
				else {
					start = { i, j + 1, 0 };
				}
				is_start = true;
			}

			if (board[i][j] == 'E' && !is_end) {
				if (i + 1 < N && board[i + 1][j] == 'E') {
					end = { i + 1, j, 1 };
				}
				else {
					end = { i, j + 1, 0 };
				}
				is_end = true;
			}
		}
	}

	cout << bfs(start, end) << '\n';
	return 0;
}
