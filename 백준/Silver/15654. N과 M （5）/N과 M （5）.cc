#include <iostream>
#include <algorithm>

using namespace std;

int N, M;
int first[9];
int arr[9];
bool visited[9];

void dfs(int num, int k) { 
    if (k == M) {
        for (auto i = 0; i < M; i++)// 배운거 활용
            cout << arr[i] << " "; 
        cout << "\n";
    }
    else { 
        for (auto i = 1; i <= N; i++) { 
            if (!visited[i]) { 
                visited[i] = true; 
                arr[k] = first[i - 1]; 
                dfs(i + 1, k + 1); 
                visited[i] = false; 
            }
        }
    }
}

int main() {
    cin >> N >> M;

    for (int i = 0; i < N; i++)
        cin >> first[i];

    sort(first, first + N); //정렬

    dfs(1, 0);
}