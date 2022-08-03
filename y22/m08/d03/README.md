# 2022.08.03.

## 더 맵게

[더 맵게](https://school.programmers.co.kr/learn/courses/30/lessons/42626)

정확성은 통과 했는데 효율성 실패

계속 sort 해서 그럴만은 하다고 생각하는데

아니고서는 할 방법이 있나?

매번 sort, pop 말고

처음 sort, 그 후 [0, 1] 삭제, 리스트 돌면서 [new] 삽입하는 식으로 해볼까

애초에 sort 를 안해도 시간 초과나네..

정답 봐야겠다.

아... pop, push 할때마다 자동 정렬해주는 heapq 라는게 있구나

나중에 또 필요하면 써야겠다