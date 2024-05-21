#include<iostream>
#include<vector>
#include<queue>
#include<algorithm>
using namespace std;
const int MAX = 505;

int vis[MAX];
int result;

bool check(vector<int> adj[], int s) {
    queue<int> q;
    q.push(s);
    vis[s] = 1;

    bool is_tree = true;

    while (!q.empty()) {
        int cur = q.front(); q.pop();

        for (int next : adj[cur]) { 
            if (vis[next] != 0 && vis[next] != vis[cur] - 1) {
                is_tree = false;
            }
            if (vis[next] != 0) continue;
            vis[next] = vis[cur] + 1;
            q.push(next);
        }
    }

    return is_tree;
}

int main(void) {
    cin.tie(NULL)->sync_with_stdio(false);

    int C = 1;
    while (1) {
        int N, M;
        cin >> N >> M;
        if (N == 0 && M == 0) break;

        vector<int> adj[MAX];
        for (int i = 0; i < M; ++i) {
            int u, v;
            cin >> u >> v;
            adj[u].push_back(v);
            adj[v].push_back(u);
        }

        fill(vis, vis + MAX, 0);

        result = 0;
        for (int i = 1; i <= N; ++i) {
            if (vis[i] == 0)
                if (check(adj, i)) result++;
        }

        cout << "Case " << C++ << ": "; 
        if (result > 1)
            cout << "A forest of " << result << " trees.\n";
        else if (result == 1)
            cout << "There is one tree.\n";
        else
            cout << "No trees.\n";
    }
}
