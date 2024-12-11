//무지성 4중포문? 시간초과 펑
//일단 2중 포문 두번 돌려서 배열 두개 다 더하고, 서로 반대되는 값이 있는지 이분탐색 조지기
#include <iostream>
#include<algorithm>
#include<vector>
using namespace std;

int arr[4005][4];
int N;
long long res;
vector<int> a, b;

int main(void)
{
	cin.tie(NULL)->sync_with_stdio(false);

	cin >> N;
	for (int i = 0; i < N; ++i) {
		for (int j = 0; j < 4; ++j) {
			cin >> arr[i][j];
		}
	}

	//A+B,C+D 부터 저장해서 정렬
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			a.push_back(arr[i][0] + arr[j][1]);
			b.push_back(arr[i][2] + arr[j][3]);
		}
	}

	sort(a.begin(), a.end());
	sort(b.begin(), b.end());

	//a 만큼 순회 하면서 b에서 -a의 값과 일치하는 lowerbound랑 upperbound 찾아서 크기 저장
	for (int i = 0; i <a.size(); ++i) {
		int b_start = lower_bound(b.begin(), b.end(), -a[i]) - b.begin();
		int b_end = upper_bound(b.begin(), b.end(), -a[i]) - b.begin();
		int temp = b_end - b_start;

		res += temp;
	}

	cout << res << '\n';
	return 0;
}
