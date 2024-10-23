//1번 섬이 결국 루트
#include <iostream>
#include<algorithm>
#include<queue>
#include<vector>
using namespace std;
using ll = long long;

const int MAX = 123458;
int N,a,p,island[MAX];
bool wolf[MAX];
ll result;
vector<int> node[MAX];
char c;

ll DFS(int st) {
	int SIZE = node[st].size();

	if (SIZE == 0) {//리프노드 도달했을 때
		if (wolf[st])//리프노드가 늑대면 무시하자
			return 0;
		else
			return island[st];//양이면 데려가기
	}

	ll tempans = 0;

	for (int i = 0; i < SIZE;++i) {
		int next = node[st][i];
		tempans += DFS(next);
	}

	//늑대면 뺴주고 아니면 더해주고
	if (wolf[st]) {
		tempans -= island[st];
	}
	else {
		tempans += island[st];
	}

	//늑대때문에 음수가 되면 0마리 데려가는걸로 처리
	if (tempans < 0) 
		return 0;
	else
		return tempans;
}

int main()
{
	cin.tie(0)->sync_with_stdio(false);
	cin >> N;
	for (int i = 2; i <= N; ++i) {
		cin >> c >> a >> p;
		if (c == 'W')
			wolf[i] = true;//섬에 있는게 늑대인지 표시

		island[i] = a;
		node[p].push_back(i);
	}

	cout << DFS(1);
}