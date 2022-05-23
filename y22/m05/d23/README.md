# 2022.05.23.

드디어 풀었다.

    if (i == data.length - 1) {
        cnt++;
    }

어제 부족했던 부분 해결 했고

조건도 살짝 바꿨다.

    if (op == '=' && wantDistance != realDistance) break;
    else if (op == '>' && wantDistance >= realDistance) break;
    else if (op == '<' && wantDistance <= realDistance) break;

이 조건이 맞는지 따지는데 머리로만 하려니까 좀 힘들었다.

간단한거라 생각해 머리로만 하려했는데 머릿속에서 더 꼬여서 시간만 낭비했다.

일단 지금은 간단한거라도 적어가면서 단계별로 검증하는 것이 효율적일 것 같다.

# 채점

해당 문제처럼 채점시 결과가 하나만 나오는 문제에서

전역 변수를 썼다면 초기화 해줘야하나보다.

전역 변수를 지양해서 코딩하고 싶다.

    class Solution {
    static int cnt = 0;
    
        public int solution(int n, String[] data) {
            cnt = 0;

# 내일 할 것

코드 리뷰 및 다른 사람 코드 확인

[다른 사람 코드](https://programmers.co.kr/learn/courses/30/lessons/1835/solution_groups?language=java)