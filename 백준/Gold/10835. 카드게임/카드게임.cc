#include <iostream>
#include<algorithm>
using namespace std;

int N;
int a[2001], b[2001];
int dp[2001][2001];

int main()
{
	cin.tie(NULL)->sync_with_stdio(false);

	cin >> N;

	//마지막 카드부터
	for (int i = N; i > 0; --i)	
		cin >> a[i]; 
	for (int i = N; i > 0; --i)	
		cin >> b[i];


	for (int i = 1; i <= N; ++i)
	{
		for (int j = 1; j <= N; ++j)
		{
			dp[i][j] = max(dp[i - 1][j - 1], dp[i - 1][j]); //모두 버리거나, 왼쪽만 버림
			
			if (a[i] > b[j]) 
				dp[i][j] = max(dp[i][j], dp[i][j - 1] + b[j]); //현재값과 오른쪽 하나버리고 더한 값 비교
		}
	}

	cout << dp[N][N]<<'\n';

	return 0;
}