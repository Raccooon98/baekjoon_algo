#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;



int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);

	int N, K, result = 0;

	int multitap[105] = { 0, }, schedule[105] = { 0, };
	cin >> N >> K;
	for (int i = 0; i < K; ++i) {
		cin >> schedule[i];
	}

	for (int i = 0; i < K; ++i) {
		bool check = false;

		for (int j = 0; j < N; ++j) {
			if (multitap[j] == schedule[i]) {
				check = true;
				break;
			}
		}

		if (check == true)
			continue;

		for (int j = 0; j < N; ++j) {
			if (multitap[j] == 0) {
				multitap[j] = schedule[i];
				check = true;
				break;
			}
		}

		if (check == true)
			continue;

		int last = -1, idx = -1; 
		for (int j = 0; j < N; ++j){
			int tmp = 0;
			for (int t = i + 1; t < K; t++){
				if (schedule[t] == multitap[j]){
					break;
				}
				tmp++;
			}

			if (tmp > last){
				last = tmp;
				idx = j;
			}
		}

		multitap[idx] = schedule[i];
		result++;
	}
	cout << result << '\n';

	return 0;
}