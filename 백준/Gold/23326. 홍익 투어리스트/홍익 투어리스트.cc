#include<iostream>
#include<vector>
#include<map>
#include<algorithm>

using namespace std;
int N, Q;
int dohyeon = 0;
map<int, bool> Map;


int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);

	cin >> N>>Q;
	for (int i = 0; i < N; ++i) {
		bool b;
		cin >> b;
		if(b)
			Map[i] = b;
	}

	for (int q = 0; q < Q; ++q) {
		int order;
		cin >> order;
		//1 지정한 곳이 명소가 되거나 풀리거나
		if (order == 1) {
			int place;
			cin >> place;
			if (Map[place - 1])
				Map.erase(place - 1);
			else
				Map[place - 1] = true;

		}
		//2 도현이가 x만큼 시계방향으로 움직이기
		else if (order == 2) {
			int x;
			cin >> x;
			dohyeon = (dohyeon + x) % N; //0으로 돌아오는 것때문에 N을 넘어가지 않게 처리
		}
		//3 도현이가 가장 가까운 명소로가려면 시계방향으로 얼마나 가야하는지, 명소가 없으면 -1 출력
		else {
			if (Map.size() == 0)
				cout << -1 << '\n';
			else {
				auto cur = Map.lower_bound(dohyeon);
				if (cur == Map.end()) {
					int len = (N - dohyeon) + Map.begin()->first;
					cout << len << '\n';
				}
				else {
					cout << cur->first - dohyeon << '\n';
				}
			}
		}
	}
	
	return 0;
}