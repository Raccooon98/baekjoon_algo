#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

int N,result;
vector<int> rope;

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);
	cin >> N;

	for (int i = 0; i < N; ++i) {
		int a;
		cin >> a;
		rope.push_back(a);
	}

	sort(rope.begin(), rope.end());
	for (auto& v : rope) {
		result = max(result, N-- * v);
	}

	cout << result;

	return 0;

}