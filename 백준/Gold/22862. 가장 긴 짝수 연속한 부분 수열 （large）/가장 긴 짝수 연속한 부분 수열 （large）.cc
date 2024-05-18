#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int N,K,result,cnt;
//int arr[1000005];
vector<int> v,arr;

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);
	cin >> N >> K;
	int n = N;
	while (n--) {
		int a;
		cin >> a;
		arr.push_back(a);
	}

	int st = 0, en = 0;
	while (en < N) {
		if (cnt > K) {
			if (arr[st] % 2 == 1)cnt--;
			st++;
		}
		else {
			if (arr[en] % 2 == 1)cnt++;
			en++;
		}
		if (cnt <= K)
			result = max(result, en - st - cnt);
	}
	cout << result << '\n';
	return 0;
}