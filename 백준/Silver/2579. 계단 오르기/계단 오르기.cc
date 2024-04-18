//dp문제 이번엔 max사용하는 문제일것같음
//1층계단 최대점수는 그냥 1층
//2층도 최대점수는 1층 +2층
//3층 최대점수는 1,2,3층 연속이 안되기때문에 1+3 1+2중에 큰 점수가 최대
//4층 최대점수는 1층 + 3+ 4, 1+2 +4
//위에 결과를 토대로 식을짜보면 i = max(i+dp(i-3)+(i-1)+,i+dp(i-2)) 이런식으로 볼 수 있을것 같다.
#include<iostream>
#include<algorithm>
using namespace std;

int dp[400];
int arr[400];

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);
	int n;
	cin >> n;
	for (int i = 1; i <= n; ++i) {
		cin >> arr[i];
	}

	dp[1] = arr[1];
	dp[2] = arr[1] + arr[2];
	dp[3] = max(arr[3] + arr[1], arr[3] + arr[2]);

	for (int i = 4; i <= n; ++i) {
		dp[i] = max(arr[i] + dp[i-2], arr[i] +arr[i-1] + dp[i - 3]);
	}

	cout << dp[n];
	return 0;

}