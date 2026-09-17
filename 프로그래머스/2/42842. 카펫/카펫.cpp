#include <bits/stdc++.h>

using namespace std;

vector<int> solution(int brown, int yellow) {
    vector<int> answer;
    
    int half = (brown+4)/2;
    int limit = half/2;
    int col = 0;
    int row = half-col;
    
    for(col=3;col<=limit;col++){
        row = half-col;
        if(col*row != brown+yellow) continue;
        else{
            if((col+row)*2-4 == brown){
                answer.push_back(row);
                answer.push_back(col);
            }
        }
    }
    
    return answer;
}