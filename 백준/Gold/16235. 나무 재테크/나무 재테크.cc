//1 <= N <= 10 인지

#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

int N, M, K;
int Food[11][11];
int Extra[11][11];
vector<int> Map[11][11];
int dx[]{ -1, -1, 0, 1, 1, 1, 0, -1 };
int dy[]{ 0, 1, 1, 1, 0, -1, -1, -1 };



int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);

	cin >> N >> M >> K;
	for (auto i = 1; i <= N; ++i) {
		for (auto j = 1; j <= N; ++j) {
			cin >> Extra[i][j];//로봇이 뿌릴 양분의 양
			Food[i][j] = 5;//기본적으로 5씩 넣고 시작
		}
	}

	for (auto i = 0; i < M; ++i) {
		int x, y, z;
		cin >> x >> y >> z;
		Map[x][y].push_back(z);//나무추가
	}
	//나무가 성장하거나 / 죽으면서 양분 추가
	for (auto h = 0; h < K; ++h) {
		for (auto i = 1; i <= N; ++i) {
			for (auto j = 1; j <= N; ++j) {
				if (Map[i][j].size() == 0)continue;//나무가없으면 지나가기

				sort(Map[i][j].begin(), Map[i][j].end());//나이순으로 정렬해주기

				int tmpfood = 0;
				vector<int> tmptree;
				for (auto k = 0; k < Map[i][j].size(); ++k) {
					/*if (Food[i][j] >= Map[i][j][k]) {
						Food[i][j] -= Map[i][j][k];
						Map[i][j][k]++;
					}
					else
						Map[i][j].erase(Map[j][j].begin()+k)
						tmpfood += (Map[i][j][k] / 2);
						죽으면 삭제하면서 가려고했는데 k에도 영향을 주고 벡터의 크기도 달라져서 제대로 작동 안함
						-> 새로운 벡터에 넣어놓고 원래꺼 비운다음에 추가하는방법으로...
					*/
					if (Food[i][j] >= Map[i][j][k]) {
						Food[i][j] -= Map[i][j][k];
						tmptree.push_back(Map[i][j][k] + 1);
					}
					else
						tmpfood += (Map[i][j][k] / 2);
				}
				Food[i][j] += tmpfood;
				Map[i][j].clear();
				for (auto k = 0; k < tmptree.size(); ++k) {
					Map[i][j].push_back(tmptree[k]);
				}
			}
		}

		//나무 번식하기
		for (auto i = 1; i <= N; ++i) {
			for (auto j = 1; j <= N; ++j) {
				int size = Map[i][j].size();
				if (size == 0)continue;

				for (auto k = 0; k < size; ++k) {
					int age = Map[i][j][k];

					if (age % 5 == 0) {//나이가 5의 배수여야지만 번식가능
						for (auto d = 0; d < 8; ++d) {
							int nx = i + dx[d];
							int ny = j + dy[d];

							if (nx<1 || nx>N || ny<1 || ny>N) continue;

							Map[nx][ny].push_back(1);//1살짜리 응애나무 추가
						}
					}
				}
			}
		}

		for (auto i = 1; i <= N; ++i) {
			for (auto j = 1; j <= N; ++j) {
				Food[i][j] += Extra[i][j];
			}
		}
	}

	int result = 0;
	for (auto i = 1; i <= N; ++i) {
		for (auto j = 1; j <= N; ++j) {
			result += Map[i][j].size();
		}
	}

	cout << result;

	return 0;
}