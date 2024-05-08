#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

int N;
int lc[30];
int rc[30];

void preorder(int cur) {
	cout << char(cur + 'A' - 1);
	if (lc[cur])preorder(lc[cur]);
	if (rc[cur])preorder(rc[cur]);
}

void inorder(int cur) {
	if (lc[cur])inorder(lc[cur]);
	cout << char(cur + 'A' - 1);
	if (rc[cur])inorder(rc[cur]);
}

void postorder(int cur) {
	if (lc[cur])postorder(lc[cur]);
	if (rc[cur])postorder(rc[cur]);
	cout << char(cur + 'A' - 1);
}

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);

	cin >> N;
	for (int i = 1; i <= N; ++i) {
		char n, l, r;
		cin >> n >> l >> r;
		if (l != '.') lc[n - 'A' + 1] = l - 'A' + 1;//문자를 숫자로 변환하는 방법
		if (r != '.') rc[n - 'A' + 1] = r - 'A' + 1;
	}

	preorder(1);//전위순회
	cout << '\n';
	inorder(1);//중위순회
	cout << '\n';
	postorder(1);//후위순회
	cout << '\n';
	return 0;
}