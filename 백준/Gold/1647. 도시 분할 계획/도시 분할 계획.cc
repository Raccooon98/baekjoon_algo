//유니온 파인드 써서 MST해보기

#include<iostream>
#include<vector>
#include<algorithm>
#include<cstring>
#include<tuple>
using namespace std;
const int MAX = 100005;

int N, M, result;
int parent[MAX], Rank[MAX] = { 0, };
vector<tuple<int, int, int>> adj;
vector<int> v;

int find(int x) {
    if (parent[x] == x) {
        return x;
    }
    else {
        parent[x] = find(parent[x]);
        return parent[x];
    }
}

// union 함수: union-by-rank (union-by-height)를 이용
void Union(int x, int y) {
    x = find(x);
    y = find(y);

    if (x == y) return; // 이미 합쳐짐

    if (Rank[x] < Rank[y]) swap(x, y);
    // x의 rank를 더 크게 만들기

    parent[y] = x; // x 밑에 y 추가하기

    if (Rank[x] == Rank[y]) Rank[x]++; // 높이가 같다면 1 추가
}

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);

    cin >> N >> M;
    for (int i = 0; i <= N; ++i)
        parent[i] = i;

    while (M--) {
        int a, b, c;
        cin >> a >> b >> c;
        adj.push_back({ c,a,b });
    }

    sort(adj.begin(), adj.end());

    for (int i = 0; i < adj.size(); ++i) {
        auto [c, a, b] = adj[i];
        
        if (find(a) != find(b)) {
            Union(a, b);
            v.push_back(c);
        }
    }

    for (int i = 0; i < v.size() - 1; ++i)
        result += v[i];
    cout << result << '\n';

    return 0;
}