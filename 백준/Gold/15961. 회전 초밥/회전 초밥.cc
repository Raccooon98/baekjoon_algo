//투포인터 같은데 좀 힘들어서 일단 이중for문으로 해보기

#include<iostream>
#include<vector>
#include<algorithm>
#include<cstring>
using namespace std;

int N, D, K, C, Max,result;
vector<int> arr;
int vis[3000005];


int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);

	cin >> N >> D >> K >> C;
	for (int i = 0; i < N; ++i) {
		int a;
		cin >> a;
		arr.push_back(a);
	}
	arr.push_back(0);
		

	int st = 0,en=0;
	int cupon = arr[0] == C ? 1 : 0;
	vis[arr[0]] = 1;
	int cnt = 1;
	Max = 1;

	while (st < N) {
		result = max(result, Max + (cupon == 0 ? 1 : 0));

		if (cnt < K) {
			en++;
			en %= N;

			if (arr[en] == C)cupon++;
			if (vis[arr[en]] == 0)Max++;
			vis[arr[en]]++;

			cnt++;
		}
		else if (cnt >= K) {
			if (arr[st] == C)cupon--;
			vis[arr[st]]--;
			if (vis[arr[st]] == 0)Max--;
			cnt--;
			st++;
		}
	}
	cout << result << '\n';
	return 0;
}