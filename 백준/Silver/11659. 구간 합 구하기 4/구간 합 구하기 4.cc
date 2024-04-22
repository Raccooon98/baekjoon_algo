#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int N,M;
int sum;

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);

	cin >> N >> M;
	
	vector<int> arr;
	vector<int>dp(N+1);
	dp[0] = 0;
	for (int i = 0; i < N; ++i) {
		int a;
		cin >> a;
		arr.push_back(a);
	}
	
	for (int i = 1; i <= N; ++i) {
		dp[i] = dp[i-1] + arr[i - 1];
	}
	
	for (int i = 0; i < M; ++i) {
		int a, b;
		cin >> a >> b;
		cout << dp[b] - dp[a-1] << '\n';
	}

	return 0;
}