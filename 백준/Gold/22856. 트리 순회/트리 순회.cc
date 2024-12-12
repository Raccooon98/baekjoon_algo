#include <iostream>
#include <vector>
using namespace std;
const int SIZE = 100005;


vector<int> arr[SIZE];
bool vis[SIZE];
int end_node, result;
bool check = true;

void similar(int node) {

    int left_node = arr[node][0];     // 노드외 좌측 자식
    int right_node = arr[node][1];    // 노드의 우측 자식

    if (left_node != -1) {
        result += 1;
        similar(left_node);
        if (check) result += 1;
    }
    if (right_node != -1) {
        result += 1;
        similar(right_node);
        if (check) result += 1;
    }
    if (node == end_node) {
        check = false;
        return;
    }
}

void inorder(int node) {
    int left_node = arr[node][0];
    int right_node = arr[node][1];

    if (left_node != -1) {
        inorder(left_node);
    }
    end_node = node;
    if (right_node != -1) {
        inorder(right_node);
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    int N; cin >> N;
    for (int i = 0; i < N; ++i) {
        int a, b, c; 
        cin >> a >> b >> c;
        arr[a].push_back(b);
        arr[a].push_back(c);
    }

    inorder(1);
    similar(1);

    cout << result;
}