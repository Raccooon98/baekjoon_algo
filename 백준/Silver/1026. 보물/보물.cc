#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

int N;


int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);

	vector<int> a,b;
	cin >> N;
	for (int i = 0; i < N; ++i) {
		int m;
		cin >> m;
		a.push_back(m);
	}
	for (int i = 0; i < N; ++i) {
		int m;
		cin >> m;
		b.push_back(m);
	}
	sort(a.begin(), a.end(), greater<int>());
	sort(b.begin(), b.end());

	int num = 0;
	for (int i = 0; i < N; ++i) {
		num += a[i] * b[i];
	}

	cout << num<<'\n';

	return 0;
}