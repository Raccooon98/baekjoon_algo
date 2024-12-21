#include <iostream>
#include<algorithm>
#include<vector>
using namespace std;

int N;
int arr[2300][2300];
int dp[2300][2300];

int main(void)
{
	cin.tie(NULL)->sync_with_stdio(false);

	cin >> N;

	//0보다 작은 수로 채우기 안하면 틀림
	for (int i = 0; i <= N; ++i) {
		for (int j = 0; j <= N; ++j) {
			arr[i][j] = -1000000000;
		}
	}

	for (int i = 1; i <= N; ++i) {
		for (int j = 1; j <= N; ++j) {
			cin >> arr[i][j];
		}
	}

	for (int i = 1; i <= N; ++i) {
		for (int j = 1; j <= N; ++j) {
			if (i == 1 && j == 1) {
				dp[i][j] = 0;
				continue;
			}

			int cost = 0;

			if (arr[i][j - 1] > arr[i][j]) {
				cost = 0;
			}
			else {
				cost = arr[i][j] - arr[i][j - 1] + 1;
			}

			int cost2 = 0;

			if (arr[i - 1][j] > arr[i][j]) {
				cost2 = 0;
			}
			else {
				cost2 = arr[i][j] - arr[i - 1][j] + 1;
			}

			dp[i][j] = dp[i][j - 1] + cost;
			dp[i][j] = min(dp[i - 1][j] + cost2, dp[i][j]);
		}
	}

	cout << dp[N][N] << '\n';
	return 0;
}