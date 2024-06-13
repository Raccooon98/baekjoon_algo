#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

pair<int, int> arr[105][10005];

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);

	int N, M;
	int result = 0;
	cin >> M >> N;
	for (int i = 0; i < M; ++i) {
		for (int j = 0; j < N; ++j) {
			int size;
			cin >> size;
			arr[i][j] = { size,j };
		}
		sort(arr[i], arr[i]+N);
	}

	for (int i = 0; i < M - 1; ++i) {
		for (int j = i + 1; j < M; ++j) {
			bool check = true;

			for (int k = 0; k < N - 1; ++k) {
				if (arr[i][k].second != arr[j][k].second) {
					check = false;
					break;
				}
				else {
					if (i != N - 1) {
						if (arr[i][k].first < arr[i][k + 1].first != arr[j][k].first < arr[j][k + 1].first) {
							check = false;
							break;
						}
					}
				}
			}
			if (check) result++;
		}
	}
	cout << result << '\n';


}