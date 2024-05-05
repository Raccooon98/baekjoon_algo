#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int N,st,en;

long long result;
bool check[100000];

int main(void) {
	cin >> N;
	vector<int> arr(N);
	for (int n = 0; n < N; ++n) {
		cin >> arr[n];
	}

	for (st = 0; st < N; ++st) {
		while (en < N) {
			if (check[arr[en]])break;
			check[arr[en]] = 1;
			en++;
		}

		result += en - st;
		check[arr[st]] = 0;
	}

	cout << result << '\n';

	return 0;
}