//이름부터 그냥 플로이드 워셜 최단거리 문제임
#include<iostream>
#include<vector>
#include<algorithm>
const int INF = 0x3f3f3f3f;
using namespace std;

int d[105][105];
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
	}
	for (int i = 1; i <= N; ++i)
		d[i][i] = 0;

	for (int k = 1; k <= N; ++k)
		for (int i = 1; i <= N; ++i)
			for (int j = 1; j <= N; ++j)
				d[i][j] = min(d[i][j], d[i][k] + d[k][j]);

	for (int i = 1; i <= N; ++i) {
		for (int j = 1; j <= N; ++j) {
			if (d[i][j] == INF)cout << "0 ";
			else cout << d[i][j] << ' ';
		}
		cout << '\n';
	}

	return 0;
}