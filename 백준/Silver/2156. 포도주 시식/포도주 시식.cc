#include<iostream>
#include<vector>
#include<algorithm>
#include<cstring>
using namespace std;

int N;
int dp[10005],arr[10005];

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);

	cin >> N;
	memset(arr, 0, sizeof(arr));
	memset(dp, 0, sizeof(dp));
	arr[0] = 0;
	for (int i = 1; i <= N; ++i) {
		cin >> arr[i];
	}
	
	dp[0] = arr[0];
	dp[1] = arr[1];
	dp[2] = arr[1] + arr[2];

	for (int i = 3; i <= N; ++i) {
		dp[i] = max(dp[i - 3] + arr[i - 1] + arr[i], max(dp[i - 2] + arr[i], dp[i - 1]));
	}

	cout << dp[N] << '\n';
	return 0;
}