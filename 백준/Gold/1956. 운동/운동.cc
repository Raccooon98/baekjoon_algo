#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;
const int INF = 1e9;

int V, E, a, b, c;
int arr[401][401];

int main() {
	cin.tie(NULL)->sync_with_stdio(false);
	cin >> V >> E;
	int res = INF;

	for (int i = 1; i <= V; ++i) {
		for (int j = 1; j <= V; ++j) {
			if (i != j) arr[i][j] = INF;
		}
	}

	for (int i = 0; i < E; ++i) {
		cin >> a >> b >> c;
		arr[a][b] = c;
	}

	for (int k = 1; k <= V; ++k) {
		for (int i = 1; i <= V; ++i) {
			for (int j = 1; j <= V; ++j) {
				if (arr[i][j] > arr[i][k] + arr[k][j]) {
					arr[i][j] = arr[i][k] + arr[k][j];
				}
			}
		}
	}


	for (int i = 1; i <= V; ++i) {
		for (int j = 1; j <= V; ++j) {
			if (i == j) 
				continue;

			res = min(res, arr[i][j] + arr[j][i]);
		}
	}
	cout << (res == INF ? -1 : res);

	return 0;
}