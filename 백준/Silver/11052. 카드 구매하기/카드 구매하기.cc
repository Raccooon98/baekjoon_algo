#include<iostream>
#include<algorithm>
using namespace std;
const int MAX = 1005;

int N; 
int arr[MAX]; 
int dp[MAX];

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);

	cin >> N;
	for (int i = 1; i <= N; ++i) {
		cin >> arr[i]; 
	}

	dp[0] = arr[0] = 0;

	for (int i = 1; i <= N; ++i) {
		for (int j = 1; j <= i; ++j) {
			dp[i] = max(dp[i], dp[i - j] + arr[j]);
		}
	}

	cout << dp[N] << '\n';

	return 0;
}