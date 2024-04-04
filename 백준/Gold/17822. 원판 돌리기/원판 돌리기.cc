#include<iostream>
#include<vector>
#include<queue>
using namespace std;


int N, M, T, result;
int dx[]{ 1,0,-1,0 };
int dy[]{ 0,1,0,-1 };

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);

	cin >> N >> M >> T;
	vector<deque<int>> plate(N+1);

	for (auto i = 1; i <= N; ++i) {
		for (auto j = 0; j < M; ++j) {
			int tmp;
			cin >> tmp;
			plate[i].push_back(tmp);
		}
	}

	for (int t = 0; t < T; ++t) {
		int X, D, K;
		
		cin >> X >> D >> K;

		//회전하기
		for (auto i = X; i <= N; i += X) {
			if (D == 0) {// 시계방향
				for (auto k = 0; k < K; ++k) {
					int back = plate[i].back();
					plate[i].pop_back();
					plate[i].push_front(back);
				}
			}
			else if (D == 1) {// 반시계 방향
				for (auto k = 0; k < K; ++k) {
					int front = plate[i].front();
					plate[i].pop_front();
					plate[i].push_back(front);
				}
			}
		}

		//인접한 중복수 찾아서 0으로 만들기
		vector<pair<int, int>> v;
		for (auto i = 1; i <= N; ++i) {
			for (auto j = 0; j < M; ++j) {
				if (plate[i][j] == 0)continue;

				for (auto d = 0; d < 4; ++d) {
					int nx = i + dx[d];
					int ny = (j + M + dy[d]) % M;

					if (nx<1 || nx>N)continue;

					if (plate[i][j] == plate[nx][ny]) {
						v.push_back({ i,j });
						v.push_back({ nx,ny });
					}
				}
			}
		}

		if (v.size() > 0) {
			for (auto&[x,y] : v) {
				plate[x][y] = 0;
			}
		}
		else {
			int sum = 0,cnt=0;
			double avg;
			for (auto i = 1; i <= N; ++i) {
				for (auto j = 0; j < M; ++j) {
					if (plate[i][j] > 0) {
						sum += plate[i][j];
						cnt+=1;
					}
				}
			}
			if (cnt == 0) {
				cout << 0;
				return 0;
			}
			else {
				avg = (double)sum / (double)cnt;
			}
			for (auto i = 1; i <= N; ++i) {
				for (auto j = 0; j < M; ++j) {
					if (plate[i][j] == 0)continue;
					if (plate[i][j] > avg) {
						plate[i][j]--;
					}
					else if (plate[i][j] < avg) {
						plate[i][j]++;
					}
					else if (plate[i][j] == avg) continue;
				}

			}

		}

	}


	for (auto i = 1; i <= N; ++i) {
		for (auto j = 0; j < M; ++j) {
			result += plate[i][j];
		}
	}

	cout << result;

	return 0;
}