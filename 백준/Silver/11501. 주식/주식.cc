//그리디 아니면 DP 일단 그리디 가능할것 같음

#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int T, N;
long long result;

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);
	cin >> T;
	while (T--) {
		cin >> N;
		vector<int> arr;
		int n = N;
		while (n--) {
			int a;
			cin >> a;
			arr.push_back(a);
		}
		result = 0;
		int Max = -100000;

		for (int i = N - 1; i >= 0; --i) {
			Max = max(Max, arr[i]);
			result += Max - arr[i];
		}

		cout << result << '\n';
	}

	return 0;

}