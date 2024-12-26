#include <iostream>
#include<algorithm>
using namespace std;

int N;

void MOO(int len, int n) {
	int prev = (len - (3 + n)) / 2;
	if (n == 0) {
		if (N == 1) {
			cout << "m" << '\n';
			return;
		}
		else {
			cout << "o" << '\n';
			return;
		}
	}

	if (N <= prev) {
		MOO(prev, n - 1);
	}
	else if (prev + 1 <= N && N < prev + (3 + n)) {
		if (prev + 1 == N) {
			cout << "m" << '\n';
		}
		else {
			cout << "o" << '\n';
		}
	}
	else {
		N -= (prev + 3 + n);
		MOO(prev, n - 1);
	}
}

int main(void)
{
	cin.tie(NULL)->sync_with_stdio(false);

	cin >> N;

	int len = 3;
	int prev = 3;
	int n = 0;
	while (len<N) {
		n++;
		prev = len;
		len = 2 * prev + 3 + n;
	}

	MOO(len, n);

	return 0;
}