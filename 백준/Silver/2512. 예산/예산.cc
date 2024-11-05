#include <iostream>
#include <algorithm>
using namespace std;

int main(void)
{
	cin.tie(NULL)->sync_with_stdio(false);

	int N, M;
	int arr[10005];
	cin >> N;
	for (int i = 0; i < N; ++i) {
		cin >> arr[i];
	}
	cin >> M;

	sort(arr, arr + N);

	int left = 0;
	int right = arr[N - 1];
	int result = 0;

	while (left <= right) {
		int mid = (left + right) / 2;
		int sum = 0;

		// 현재 mid를 상한으로 설정하여 예산 합계 계산
		for (int i = 0; i < N; ++i) {
			if (arr[i] > mid)
				sum += mid;
			else
				sum += arr[i];
		}

		// 예산 합계가 M을 초과하지 않으면 상한선을 올려본다.
		if (sum <= M) {
			result = mid;
			left = mid + 1;
		}
		else {
			right = mid - 1;
		}
	}

	cout << result;
	return 0;
}
