#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;
const int SIZE = 105;
const int INF = 2147483647;

int N, M, is_cycle;
vector<pair<int, int>> adj[SIZE];
vector<int> rev[SIZE];
int dist[SIZE], pre[SIZE], vis[SIZE];

int main() {
    cin.tie(NULL)->sync_with_stdio(false);

    cin >> N >> M;
    for (int i = 0; i < M; ++i) {
        int st, en, dist;
        cin >> st >> en >> dist;
        adj[st].push_back({ en, -dist });
        rev[en].push_back(st);
    }

    queue<int> q;
    q.push(N);
    vis[N] = 1;
    while (!q.empty()) {
        int cur = q.front();
        q.pop();
        for (auto& next : rev[cur]) {
            if (!vis[next]) {
                vis[next] = 1;
                q.push(next);
            }
        }
    }

    fill(dist, dist + SIZE, INF);
    fill(pre, pre + SIZE, 0);
    dist[1] = 0;
    for (int i = 1; i <= N; ++i) {
        for (int cur = 1; cur <= N; ++cur) {
            if (dist[cur] == INF) continue;

            for (auto& [next, cost] : adj[cur]) {
                if (dist[next] > dist[cur] + cost && vis[next]) {
                    dist[next] = dist[cur] + cost;
                    pre[next] = cur;
                    if (i == N && vis[next]) is_cycle = 1;
                }
            }
        }
    }

    if (is_cycle) {
        cout << -1;
    }
    else {
        vector<int> ans;
        int idx = N;
        while (idx >= 1) {
            ans.push_back(idx);
            idx = pre[idx];
        }

        reverse(ans.begin(), ans.end());
        for (auto& k : ans) cout << k << " ";
    }

    return 0;
}
