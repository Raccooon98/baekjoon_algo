#include<iostream>
#include<algorithm>
using namespace std;

int N, M;
int arr[1000004];

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);
	cin >> N;
	for (int i = 0; i < N; ++i) {
		cin >> arr[i];
	}
	sort(arr, arr + N);
	cin >> M;
	for (int j = 0; j < M; ++j) {
		int a;
		cin >> a;
		cout << binary_search(arr, arr + N, a) << '\n';
	}

	return 0;
}