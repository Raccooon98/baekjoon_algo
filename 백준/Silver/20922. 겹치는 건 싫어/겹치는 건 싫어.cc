#include <iostream>
#include <algorithm>

using namespace std;

int N, K, s, e, result;
int num[200005], cnt[100005];
bool check;

int main()
{
	cin.tie(NULL)->sync_with_stdio(false);

	cin >> N >> K;
	for (int i = 1; i <= N; ++i){
		cin >> num[i];
	}

	s = 1;
	e = 1;
	while (s <= e && e <= N){
		while (e <= N){
			if (cnt[num[e]] == K)
				break;

			cnt[num[e++]]++;
		}

		result = max(result, e - s);
		check = true;

		while (s < e && check){
			if (cnt[num[s]] == K)
				check = false;

			cnt[num[s++]]--;
		}
	}

	cout << result << "\n";

	return 0;
}