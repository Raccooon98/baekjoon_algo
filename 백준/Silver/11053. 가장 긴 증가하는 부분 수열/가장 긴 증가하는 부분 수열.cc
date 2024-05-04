//이문제도 DP로 풀면 될것 같음
#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;
int N, Maxcnt = 0;

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);

	cin >> N;
	vector<int> dp(N,1), arr(N);
	for (int i = 0; i < N; ++i) {
		cin >> arr[i];
	}

	for (int i = 1; i < N; ++i) {
		for (int j = 0; j < i; ++j) {
			if (arr[j] < arr[i]) {
				dp[i] = max(dp[i], dp[j] + 1);
			}
		}
	}

	int result = 0;
	for (auto v : dp) {
		result = max(result, v);
	}

	cout << result << '\n';

	return 0;

}