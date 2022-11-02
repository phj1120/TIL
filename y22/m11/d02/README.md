# 2022.11.02.

## 3.Longest Substring Without Repeating Characters

[Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)

어떻게 풀겠다는 알겠는데, 경계값에서 자꾸 틀린다.

30분만하고 자자 했던게 이미 두시간 정도 되도록 못해결해서 일단 자고 일어나서 수정하려고 한다.

살짝 수정해서 풀기는 했으나, 실행 시간이 오래 걸려서 강의 보고 개선함.

처음엔 어딜 고쳐야할지 몰랐는데 구현해 둔 코드를 보고,

이렇게도 구현 할 수 있구나 싶었음.

비슷한 아이디어지만, 어떻게 구현하느냐에 따라 효율차이가 크게 난다.

i 대신 right 를 이용한 것

if 문 안써도 되도록 로직을 생각 한 것

subString 은 항상 중복이 없도록해 범위나 이런 것들을 간단하게 했다.
