//이중 for문으로 돌리면 가능하기한데 N이 20000이라 안됨
#include <iostream>
#include<vector>
#include<algorithm>
using namespace std;

string arr[20001];
int n,l,r;
int max_size = 0;


int main(void) {
    cin.tie(NULL)->sync_with_stdio(false);

    cin >> n;
    l = r = n;
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            if (arr[i] == arr[j]) {
                continue;
            }
            int length = min(arr[i].size(), arr[j].size());
            if (length == arr[i].size()) {
                int temp = 0;
                for (int k = 0; k < arr[i].size(); k++) {
                    if (arr[i][k] != arr[j][k]) {
                        break;
                    }
                    temp++;
                }

                if (temp > max_size) {
                    max_size = temp;
                    l = i;
                    r = j;
                }

            }
            else if (length == arr[j].size()) {
                int temp = 0;
                for (int k = 0; k < arr[j].size(); k++) {
                    if (arr[i][k] != arr[j][k]) {
                        break;
                    }
                    temp++;

                }

                if (temp > max_size) {
                    max_size = temp;
                    l = i;
                    r = j;
                }

            }

        }
    }
    int small = min(l, r);
    int big = max(l, r);

    cout << arr[small] << '\n';
    cout << arr[big];

}