#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

struct INFO {
	int s, e, t;
};


const long long INF = 1e18;
int TC,S,E,T,N,M,W;
long long d[500];
bool is_minuscycle=false;
vector<pair<int, int>> adj[500];

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);

	cin >> TC;
	for (int tc = 0; tc < TC; ++tc) {
		is_minuscycle = false;
		cin >> N >> M >> W;
		vector<INFO> adj;

		for (int i = 0; i < M; ++i) {
			cin >> S >> E >> T;
			adj.push_back({ S,E,T });
			adj.push_back({ E,S,T });
		}
		for (int i = 0; i < W; ++i) {
			cin >> S >> E >> T;
			adj.push_back({ S,E,-T });
		}

		vector<int> d(N + 1, INF);

		d[1] = 0;
		for (int i = 1; i < N; ++i) {
			for (auto&[s,e,t]:adj) {
				if (d[e] > d[s] + t)
					d[e] = d[s] + t;
			}
		}

		for (auto& [s, e, t] : adj) {
			if (d[e] > d[s] + t) {
				is_minuscycle = true;
			}
		}


		if (is_minuscycle)
			cout << "YES\n";
		else
			cout << "NO\n";

	}

	return 0;
}