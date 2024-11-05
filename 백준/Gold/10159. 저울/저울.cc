#include <iostream>
#include<algorithm>
using namespace std;

int arr[105][105];

int main(void)
{
	cin.tie(NULL)->sync_with_stdio(false);

	int N,M, a, b;
	cin >> N >> M;

	for (int i = 0; i < M; ++i) {
		cin >> a >> b;

		arr[a][b] = 1;
		arr[b][a] = -1;
	}

	for (int k = 1; k <= N; ++k) {
		for (int i = 1; i <= N; ++i) {
			for (int j = 1; j <= N; ++j) {
				if (arr[i][k] == arr[k][j] && arr[i][k] != 0) {
					arr[i][j] = arr[i][k];
				}
			}
		}
	}

	for (int i = 1; i <= N; ++i) {
		int cnt =  N - 1;
		for (int j = 1; j <= N; ++j) {
			if (arr[i][j] != 0)cnt--;
		}
		cout << cnt << '\n';
	}

	return 0;
}