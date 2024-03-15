//cctv 감시할 수 있는 구역에 표시해놓고 표시 안된 영역 갯수 세기
//cctv 가 감시할수 있는 모든 경우의 수 탐색
#include<iostream>
#include<vector>
#include<queue>
#include<algorithm>
using namespace std;

int n, m, arr[9][9], ans = 2147483647;
vector<pair<int, int> > cctv;

void up(int arr[][9], int x, int y) {
	for (auto i = x - 1; i >= 0; --i) {

		if (arr[i][y] == 0) {
			arr[i][y] = -1;
		}
		else if (arr[i][y] == 6) {
			break;
		}
	}
}

void down(int arr[][9], int x, int y) {
	for (auto i = x + 1; i < n; ++i) {
		if (arr[i][y] == 0) {
			arr[i][y] = -1;
		}
		else if (arr[i][y] == 6) {
			break;
		}
	}
}

void Left(int arr[][9], int x, int y) {
	for (auto i = y - 1; i >= 0; --i) {
		if (arr[x][i] == 0) {
			arr[x][i] = -1;
		}
		else if (arr[x][i] == 6) {
			break;
		}
	}

}

void Right(int arr[][9], int x, int y) {
	for (auto i = y + 1; i < m; ++i) {
		if (arr[x][i] == 0) {
			arr[x][i] = -1;
		}
		else if (arr[x][i] == 6) {
			break;
		}
	}

}

void arr_init(int tmp[][9], int arr[][9]) {
	for (auto i = 0; i < n; ++i) {
		for (int j = 0; j < m; j++) {
			tmp[i][j] = arr[i][j];
		}
	}

}

void DFS(int arr[][9], int L) {

	int tmp[9][9];
	arr_init(tmp, arr);

	if (L == cctv.size()) {

		int cnt = 0;
		for (auto i = 0; i < n; ++i) {
			for (auto j = 0; j < m; ++j) {
				if (arr[i][j] == 0) {
					cnt++;
				}
			}
		}
		ans = min(cnt, ans);

		return;

	}
	else {
		int x = cctv[L].first;
		int y = cctv[L].second;

		if (arr[x][y] == 1) {
			up(tmp, x, y);
			DFS(tmp, L + 1);
			arr_init(tmp, arr);

			down(tmp, x, y);
			DFS(tmp, L + 1);
			arr_init(tmp, arr);

			Left(tmp, x, y);
			DFS(tmp, L + 1);
			arr_init(tmp, arr);

			Right(tmp, x, y);
			DFS(tmp, L + 1);
			arr_init(tmp, arr);

		}
		else if (arr[x][y] == 2) {
			up(tmp, x, y);
			down(tmp, x, y);
			DFS(tmp, L + 1);
			arr_init(tmp, arr);

			Left(tmp, x, y);
			Right(tmp, x, y);
			DFS(tmp, L + 1);
			arr_init(tmp, arr);

		}
		else if (arr[x][y] == 3) {
			up(tmp, x, y);
			Left(tmp, x, y);
			DFS(tmp, L + 1);
			arr_init(tmp, arr);

			up(tmp, x, y);
			Right(tmp, x, y);
			DFS(tmp, L + 1);
			arr_init(tmp, arr);

			down(tmp, x, y);
			Left(tmp, x, y);
			DFS(tmp, L + 1);
			arr_init(tmp, arr);

			down(tmp, x, y);
			Right(tmp, x, y);
			DFS(tmp, L + 1);
			arr_init(tmp, arr);
		}
		else if (arr[x][y] == 4) {
			up(tmp, x, y);
			down(tmp, x, y);
			Left(tmp, x, y);
			DFS(tmp, L + 1);
			arr_init(tmp, arr);

			up(tmp, x, y);
			down(tmp, x, y);
			Right(tmp, x, y);
			DFS(tmp, L + 1);
			arr_init(tmp, arr);

			up(tmp, x, y);
			Left(tmp, x, y);
			Right(tmp, x, y);
			DFS(tmp, L + 1);
			arr_init(tmp, arr);


			down(tmp, x, y);
			Left(tmp, x, y);
			Right(tmp, x, y);
			DFS(tmp, L + 1);
			arr_init(tmp, arr);
		}
		else if (arr[x][y] == 5) {
			up(tmp, x, y);
			down(tmp, x, y);
			Left(tmp, x, y);
			Right(tmp, x, y);
			DFS(tmp, L + 1);
			arr_init(tmp, arr);
		}
	}
}

int main() {
	cin.tie(NULL)->sync_with_stdio(false);

	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> arr[i][j];

			if (arr[i][j] > 0 && arr[i][j] <= 5) {
				cctv.push_back({ i,j });
			}
		}
	}


	DFS(arr, 0);


	cout << ans << '\n';

	return 0;
}