//아무리 봐도 dp 다 점화식을 찾아보자
//스티커를 떼면 상하좌우를 못쓰게 된다 -> 대각선으로 골라가면서 왼쪽에서 오른쪽으로 
// arr[0][0] -> arr[1][1] -> arr[0][2] -> arr[1][3]...
// arr[1][0] -> arr[0][1] -> arr[1][2] -> arr[0][3]... 이런식으로 두개의 경우 중에 더 점수가 큰 결과를 선택하게 하면 될것 같다.
//이 방법을 식으로만 표현하면 끝
//생각해보니까 바로 대각선 말고 그 다음칸이 더 클수도 있다. 
#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

int T, N;
long long dp[2][100005];
long long arr[2][100005];

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);

	cin >> T;
	while (T--) {
		cin >> N;
		for (int i = 0; i < 2; ++i) {
			for (int j = 1; j <= N; ++j) {
				cin >> arr[i][j];
				dp[i][j] = 0;
			}
		}
		

		dp[0][0] = 0;
		dp[1][0] = 0;
		dp[0][1] = arr[0][1];
		dp[1][1] = arr[1][1];

		for (int i = 2; i <= N; ++i) {
			dp[0][i] = max(dp[1][i - 1], dp[1][i - 2]) + arr[0][i];
			dp[1][i] = max(dp[0][i - 1], dp[0][i - 2]) + arr[1][i];
		}
		cout << max(dp[0][N], dp[1][N]) << '\n';
	}

	return 0;

}