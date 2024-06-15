#include<iostream>
#include<algorithm>
using namespace std;
using ll = long long;

int arr[1005][1005] = { 0, };
int index[1005];
ll result=1'000'000'000;

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);
	
	int N, M;
	cin >> N >> M;

	for (int i = 0; i < N; ++i) {
		for (int j = 0; j < M; ++j) {
			cin >> arr[i][j];
		}
	}

	for (int i = 0; i < N; ++i) {
		sort(arr[i], arr[i] + M);
	}

	while (true) {
		ll Max = 0,Min= 1'000'000'000;
		int Min_idx = 0, Max_idx = 0;

		for (int i = 0; i < N; ++i){
			if (arr[i][index[i]] < Min){
				Min = arr[i][index[i]];
				Min_idx = i;
			}

			if (arr[i][index[i]] > Max){
				Max = arr[i][index[i]];
				Max_idx = i;
			}
		}

		result = min(result, Max - Min);

		index[Min_idx]++;

		if (index[Min_idx] == M)
			break;
	}

	cout << result<<'\n';

	return 0;
}