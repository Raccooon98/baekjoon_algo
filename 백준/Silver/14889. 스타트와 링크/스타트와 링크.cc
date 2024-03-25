#include<iostream>
#include<algorithm>
#include<cmath>
#include<vector>
#define MAX 21
using namespace std;

bool team[MAX];
int stats[MAX][MAX];
int N;
int Min = 10000000;

void maketeam(int idx, int num) {
	vector<int> start, link;
	int start_score = 0; int link_score = 0;
	
	if (num == (N / 2)) {
		for (auto i = 0; i < N; ++i) {
			if (team[i] == 1)
				start.push_back(i);//조합으로 뽑은 팀 
			else
				link.push_back(i);//나머지 남는 사람들 팀
		}

		for (auto i = 0; i < N/2; ++i) {
			for (auto j = 0; j < N/2; ++j) {
				start_score += stats[start[i]][start[j]];
				link_score += stats[link[i]][link[j]];
			}
		}
		Min = min(Min,abs(start_score - link_score));
		return;
	}

	for (auto i = idx; i < N; ++i) {
		if (team[i])continue;
		else {
			team[i] = 1;
			maketeam(i, num + 1);
			team[i] = 0;
		}
	}
}

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);

	cin >> N;
	for (auto i = 0; i < N; ++i) {
		for (auto j = 0; j < N; ++j) {
			cin >> stats[i][j];
		}
	}

	maketeam(0, 0);
	cout << Min;
	return 0;
}