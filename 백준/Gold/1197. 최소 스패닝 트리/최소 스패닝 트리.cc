#include <iostream>
#include <vector>
#include<tuple>
#include <algorithm>
using namespace std;

int V, E, result;
int parent[10001];

int find(int x) {
	if (parent[x] == x)return x;
	else return parent[x] = find(parent[x]);
}
void Union(int x, int y) {
	x = find(x);
	y = find(y);
	parent[y] = x;
}
bool sameparent(int x, int y) {
	x = find(x);
	y = find(y);
	if (x == y)return true;
	else return false;
}
int main() {
	
	cin >> V >> E;
	
	vector<tuple<int,int,int>>v;
	for (int i = 0; i < E; i++) {
		int from, to, cost;
		cin >> from >> to >> cost;
		v.push_back({ cost,from,to });
	}
	sort(v.begin(), v.end());
	for (int i = 1; i <= V; i++)parent[i] = i;
	for (int i = 0; i < v.size(); i++) {
		auto& [a, b, c] = v[i];
		if (find(b)!=find(c)) {
			Union(b, c);
			result += a;
		}
	}
	cout << result;
}