#include<iostream>
#include<vector>
#include<algorithm>
#include<tuple>
using namespace std;

int N;

int arr[301][301];
int parents[301];
vector<tuple<int,int,int >> v;


int find(int a) {
    if (parents[a] == a) return a;
    return parents[a] = find(parents[a]);
}


void Union(int a, int b) {
    a = find(a);
    b = find(b);

    if (a > b) parents[a] = b;
    else parents[b] = a;
}

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);

    cin >> N;

    int cost;
    for (int i = 1; i <= N; i++) {
        cin >> cost;
        v.push_back({ cost, 0, i });
    }

    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= N; j++) {
            cin >> arr[i][j];
        }
    }

    for (int i = 1; i <= N; i++) {
        for (int j = i + 1; j <= N; j++) {
            v.push_back({arr[i][j], i, j });
        }
    }

    sort(v.begin(), v.end());
    for (int i = 0; i <= N; i++) parents[i] = i;

    int sum = 0;
    for (int i = 0; i < v.size(); i++) {
        auto [cost, a, b] = v[i];

        if (find(a) != find(b)) {
            Union(a,b);
            sum += cost;
        }
    }

    cout << sum << '\n';


}