//연습장에 그려본 결과 1->1 , 2->3, 3->5, 4->11, 5->21 이다 arr[i] = arr[i-2]*2+arr[i-1] 
#include<iostream>
#include<algorithm>
using namespace std;

int N;
int arr[1100];

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);

	cin >> N;
	arr[0] = 0;
	arr[1] = 1;
	arr[2] = 3;

	for (int i = 3; i <= N; ++i) {
		arr[i] = arr[i - 2] * 2 + arr[i - 1];
		arr[i] %= 10007;
	}

	cout << arr[N] << '\n';

	return 0;
}