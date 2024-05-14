#include<iostream>
#include<vector>
#include<queue>
#include<tuple>
#include<algorithm>
using namespace std;
const int INF = 0x7f7f7f7f;

int N,M,X,result;
vector<pair<int, int>> v[1005];
int d[1005];

void Dijkstra(int a, int t) {
	fill(d, d +N+1, INF);
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
    pq.push({ 0, a });
    d[a] = 0; 
    while (!pq.empty()) {
        auto [cd, cx] = pq.top(); pq.pop();
        if (cx == t) { 
            result = d[cx]; 
            break;
        }

        for (int i = 0; i < v[cx].size(); ++i) {
            auto [nx, nd] = v[cx][i];
            nd += cd;
            if (d[nx] > nd) {
                d[nx] = nd; 
                pq.push({ nd, nx }); 
            }
        }
    }
}


int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);

	cin >> N >> M >> X;

	int num = 0, num1, num2;
	for (int i = 0; i < M; ++i) {
		int a, b, c;
		cin >> a >> b >> c;
		v[a].push_back({ b,c });
	}

	for (int i = 1; i <= N; ++i) {
		Dijkstra(i, X);
		num1 = result;
		Dijkstra(X, i);
		num2 = result;
		num = max(num, num1 + num2);
	}

	cout << num << '\n';
	return 0;
}