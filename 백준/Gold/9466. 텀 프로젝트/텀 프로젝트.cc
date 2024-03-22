#include<iostream>
#include<vector>
#include<cstring>
#define MAX 100001

using namespace std;
using pii = pair<int, int>;
int T, n,result;
int Student[MAX];
bool vis[MAX];
bool isteam[MAX];

void check_team(int num) {
	vis[num] = 1;//방문
	int next = Student[num];//다음 인덱스

	if (!vis[next])//방문안했으면 바로 탐색
		check_team(next);

	else if (!isteam[next]) {//방문 안했는데 팀 아니면
		int cur = next;
		int length = 0;

		while (cur != num) {
			isteam[cur] = 1;
			length++;
			cur = Student[cur];
		}
		length++;
		result += length;
	}
	isteam[num] = 1;
}


int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);

	cin >> T;
	while (T--) {
		//초기화
		memset(vis, 0, sizeof(vis));
		memset(isteam, 0, sizeof(isteam));
		result = 0;


		cin >> n;
		
		for (auto i = 1; i <= n; ++i) {
			cin >> Student[i];
		}
		
		for (auto i = 1; i <= n;++i) {
			if (!vis[i])
				check_team(i);
		}

		cout << n - result << '\n';
	}
}