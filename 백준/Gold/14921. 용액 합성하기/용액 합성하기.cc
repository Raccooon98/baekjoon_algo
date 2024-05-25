//N의 최대값이 10만이기떄문에 방법을 생각해봤을때 투 포인터가 맞는것 같음.
#include<iostream>
#include<vector>
#include<queue>
#include<algorithm>
#include<cmath>
using namespace std;

int N,result;

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);
	cin >> N;
	vector<long long> arr;
	for (int i = 0; i < N; ++i) {
		int a;
		cin >> a;
		arr.push_back(a);
	}

	int st = 0;
	int en = N - 1;
	int minnum = abs(arr[st] + arr[en]);
	result = arr[st] + arr[en];
	while (st < en) {
		int num = arr[st] + arr[en];
		if (abs(num) < minnum) {
			minnum = abs(num);
			result = num;
		}

		if (num < 0)
			st++;
		else
			en--;
	}
	cout << result << '\n';

	return 0;
}