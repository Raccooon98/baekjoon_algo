//기울기만 두번 구해서 비교하면 되는 문제 아닌가 라는 생각으로 시작
#include <iostream>
#include<vector>
#include<algorithm>
using namespace std;

int p[3][2];

int main() {
	cin.tie(NULL)->sync_with_stdio(false);

	for (int i = 0; i < 3; ++i) {
		cin >> p[i][0] >> p[i][1];
	}

	int check = (p[1][0] - p[0][0]) * (p[2][1] - p[1][1]) - (p[1][1] - p[0][1]) * (p[2][0] - p[1][0]);

	if (check == 0) {
		cout << 0; // 일직선 상에 있음
	}
	else if (check > 0) {
		cout << 1; // 반시계 방향
	}
	else {
		cout << -1; // 시계 방향
	}

	return 0;
}
