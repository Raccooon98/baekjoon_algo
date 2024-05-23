//음수가 중요한듯? 양수는 그냥 정렬해서 큰수 끼리 곱하면 장땡인데, 
// 음수는 음수끼리 곱해서 양수로 만들거나, 
// 0이랑 곱해서 없애는게 최선이라 이부분 잘 고려해보기

#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int N, result;
vector<int> neg, pos;//음수 양수
int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);

	cin >> N;

	for (int i = 0; i < N; ++i) {
		int a;
		cin >> a;
		if (a > 0)pos.push_back(a);
		else neg.push_back(a);
	}

	sort(pos.begin(), pos.end(), greater<>());
	sort(neg.begin(), neg.end());

	if ((int)pos.size() % 2 != 0)result += pos[(int)pos.size() - 1];//홀수개면 가장 작은 양수하나만 더해놓기
	for (int i = 0; i < (int)pos.size() - 1;i+=2) {
		if (pos[i + 1] == 1)result += pos[i] + pos[i + 1];
		else if (pos[i + 1] > 0)result += pos[i] * pos[i + 1];
	}
	if ((int)neg.size() % 2 != 0)result += neg[(int)neg.size() - 1];
	for (int i = 0; i < (int)neg.size() - 1; i += 2)
		result += neg[i] * neg[i + 1];

	cout << result << '\n';

	return 0;
}