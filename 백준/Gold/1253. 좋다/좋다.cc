#include<iostream>
#include<algorithm>
using namespace std;

int arr[2005];

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);

	int N,target;
	int result = 0;

	cin >> N;
	for (int n = 0; n < N; ++n) {
		cin >> arr[n];
	}

	sort(arr, arr + N);

	for (int i = 0; i < N; ++i) {
		target = arr[i];
		int st = 0, en = N - 1, sum;
		while (st < en) {
			sum = arr[st] + arr[en];
			if (sum == target) {
				if (st != i && en != i) {
					result++;
					break;
				}
				else if (st == i) st++;
				else if (en == i) en--;
			}
			else if (sum < target) st++;
			else en--;
		}
	}

	cout << result<<'\n';

	return 0;
}