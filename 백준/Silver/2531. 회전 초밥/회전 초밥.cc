//투포인터 같은데 좀 힘들어서 일단 이중for문으로 해보기

#include<iostream>
#include<vector>
#include<algorithm>
#include<cstring>
using namespace std;

int N, D, K, C,Max;
int arr[30005];
bool vis[30005];


int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);

	cin >> N >> D >> K >> C;
	for (int i = 0; i < N; ++i)
		cin >> arr[i];

	for (int i = 0; i < N; ++i) {
		int check = 0;
		int cupon = 1;
		for (int j = i; j < i + K; ++j) {
			if (!vis[arr[j % N]]) vis[arr[j % N]] = true;
			else check++;
		}
		if (vis[C])cupon = 0;

		Max = max(Max, K - check + cupon);
		memset(vis, false, sizeof(vis));
	}
	cout << Max << '\n';
	return 0;
}