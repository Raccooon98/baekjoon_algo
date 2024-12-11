//너무 막막해서 k 범위가 2~5길래 그냥 케이스로 나눠서 풀기
#include <iostream>
#include<algorithm>
using namespace std;
int l, r, k;

int main(void)
{
	cin.tie(NULL)->sync_with_stdio(false);

	cin >> l >> r >> k;
	
	int minNum = 0;
	int answer = 0;

	switch (k) {
	case 2:
		answer = max(r - max(l, 3) + 1, 0);
		break;
	case 3:
		minNum = max(l, 6);
		for (int i = minNum; i <= r; i++)
			if (i % 3 == 0) answer++;
		break;
	case 4:
		minNum = max(l, 10);
		for (int i = minNum; i <= r; i++)
			if (i % 2 == 0 && i != 12) answer++;
		break;
	case 5:
		minNum = max(l, 15);
		for (int i = minNum; i <= r; i++)
			if (i % 5 == 0) answer++;
		break;
	default:
		break;
	}

	cout << answer << '\n';

	return 0;
}