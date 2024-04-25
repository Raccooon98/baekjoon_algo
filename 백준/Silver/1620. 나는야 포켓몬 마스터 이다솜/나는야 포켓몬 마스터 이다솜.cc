#include<iostream>
#include<algorithm>
#include<unordered_map>
#include<vector>
#include<string>
using namespace std;

int N,M;

unordered_map<string, int> pokemonnum;
unordered_map<int, string> pokemonname;
int main(void) {
	cin.tie(NULL)->sync_with_stdio(false);

	cin >> N >> M;

	for (int i = 1; i <= N; ++i) {
		string name;
		cin >> name;
		pokemonnum[name] = i;
		pokemonname[i] = name;
	}

	for (int i = 0; i < M; ++i) {
		string question;
		cin >> question;
		if (isdigit(question[0])) {
			cout << pokemonname[stoi(question)] << '\n';
		}
		else
			cout << pokemonnum[question] << '\n';
			
	}
	return 0;
}