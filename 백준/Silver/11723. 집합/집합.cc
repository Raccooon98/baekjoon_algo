#include<iostream>
#include<algorithm>
using namespace std;

int state;

int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);

	int M;
	cin >> M;

	while (M--) {
		string command;
		int x;

		cin >> command;

		if (command == "add") {
			cin >> x;
			state |= (1 << (x - 1));
		}
		else if (command == "remove") {
			cin >> x;
			state &= (~(1 << (x - 1)));
		}
		else if (command == "check") {
			cin >> x;
			cout << ((state >> (x - 1)) & 1) << '\n';
		}
		else if (command == "toggle") {
			cin >> x;
			state ^= (1 << (x - 1));
		}
		else if (command == "all") {
			state = 0xfffff;
		}
		else {
			state = 0;
		}
	}

	return 0;
}