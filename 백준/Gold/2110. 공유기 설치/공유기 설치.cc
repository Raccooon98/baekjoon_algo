#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;
int N, C, st, en, mid, result, router,last;
int dohyeon = 0;


int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);

	cin >> N >> C;

	vector<int> arr(N);
	for (int i = 0; i < N; ++i) {
		cin >> arr[i];
	}

	sort(arr.begin(), arr.end());

	st = 1;
	en = arr[N - 1] - arr[0];

	while (st <= en) {
		router = 1;
		mid = (st + en) / 2;
		last = arr[0];

		for (int i = 1; i < N; ++i) {
			if (arr[i] - last >= mid) {
				router++;
				last = arr[i];
			}
		}
		if (router >= C) {
			result = max(result, mid);
			st = mid + 1;
		}
		else
			en = mid - 1;
	}

	cout << result << '\n';

	return 0;
}