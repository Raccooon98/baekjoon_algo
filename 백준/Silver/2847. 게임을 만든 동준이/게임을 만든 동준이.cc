#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int N;
vector<int> arr;

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);

	cin >> N;
	for (int i = 0; i < N; ++i) {
		int a;
		cin >> a;
		arr.push_back(a);
	}
	int cnt = 0;
	//sort(arr.begin(), arr.end(), greater<>());
	for (int i = N-2; i >=0; --i) {
		while (arr[i] >= arr[i + 1])
		{
			arr[i]--;
			cnt++;
		}
	}

	cout << cnt << '\n';

	return 0;
}