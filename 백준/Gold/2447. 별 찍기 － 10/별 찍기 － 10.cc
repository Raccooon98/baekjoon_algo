// (N/3)×(N/3) 정사각형을 크기 N/3의 패턴으로 둘러싼 형태이다. 를 보자마자 떠오르는 분할정복 이제 슬슬 익숙할지도
#include<iostream>
#include<algorithm>
using namespace std;

void star(int x, int y, int size) {
	//3칸짜리 사각형 기준으로 3으로나눈 나머지가 0이면 1번째 1이면가운데 2이면 3번째
	if (x/size % 3 == 1 && y/size % 3 == 1) {
		cout << ' ';
	}
	else if (size / 3 == 0) {
		cout << "*";
	}
	else {
		star(x, y, size / 3);
	}

}

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);
	int N;
	cin >> N;
	for (auto i = 0; i < N; ++i) {
		for (auto j = 0; j < N; ++j) {
			star(i, j, N);
		}
		cout << '\n';
	}
}