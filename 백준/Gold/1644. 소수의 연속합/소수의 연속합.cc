//소수 구하는 알고리즘 중에 에라토스테네스의 체 라는 알고리즘을 검색을 통해 알았다.
//소수들을 저장해놓고 이걸로 투포인터 써서 검증하면서 문제풀면 될듯

#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

int n{}, st{}, en{}, sum{}, result{};

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);

	cin >> n;
	//에라토스테네스의 체
	vector < bool> v(n + 1, 1);

	for (int i = 2; i * i <= n; ++i) {
		if (v[i] == 0)continue;
		for (int j = i + i; j <= n; j += i) {
			v[j] = 0;
		}
	}
	//소수 저장
	vector<int> prime;
	for (int i = 2; i<= n; ++i) {
		if (v[i])prime.push_back(i);
	}

	//투포인터
	while (1) {
		if (sum > n) {
			sum -= prime[st];
			st++;
		}
		else if (sum < n) {
			if (en >= prime.size())break;
			sum += prime[en];
			en++;
		}
		else {
			result++;
			if (en >= prime.size())break;
			sum += prime[en];
			en++;
		}
	}
	cout << result << '\n';

	return 0;
}