#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

const int INF = 0x3f3f3f3f;
int d[105][105],nxt[105][105];
int N, M;

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);

	cin >> N >> M;
	for (int i = 1; i <= N; ++i) {
		fill(d[i], d[i] + 1 + N, INF);
	}
	for (int m = 0; m < M; ++m) {
		int a, b, c;
		cin >> a >> b >> c;
		d[a][b] = min(d[a][b], c);
		nxt[a][b] = b;
	}
	for (int i = 1; i <= N; ++i)
		d[i][i] = 0;

	for (int k = 1; k <= N; ++k)
		for (int i = 1; i <= N; ++i)
			for (int j = 1; j <= N; ++j) {
				if (d[i][k] + d[k][j] < d[i][j]) {
					d[i][j] = min(d[i][j], d[i][k] + d[k][j]);
					nxt[i][j] = nxt[i][k];
				}
				
			}
	for (int i = 1; i <= N; ++i) {
		for (int j = 1; j <= N; ++j) {
			if (d[i][j] == INF)cout << "0 ";
			else cout << d[i][j] << ' ';
		}
		cout << '\n';
	}

	for (int i = 1; i <= N; ++i) {
		for (int j = 1; j <= N; ++j) {
			if (d[i][j] == 0 || d[i][j] == INF) {
				cout << "0\n";
				continue;
			}

			vector<int> path;
			int st = i;
			while (st != j) {
				path.push_back(st);
				st = nxt[st][j];
			}
			path.push_back(j);
			cout << path.size() << ' ';
			for (auto x : path)
				cout << x << ' ';
			cout << '\n';
		}
	}

	return 0;
}