# 2022.04.09.

큐 없이 재귀로만 구현 했는데

시간이 그렇게 안줄었다.

답이랑 합쳐 봤는데

Scanner 써서 그런 듯

BufferedReader 를 쓰자.

i, j, width, height, x, y, n, m

0, 1, false, true

dfs(x, y) arr[y][x]

이렇게 비슷한걸 의미하지만 표현방법이 다른 것 때문에 진짜 헷갈려서 힘들었다.

길더라도 정의를 제대로 하는게 좋은 것 같다.

i, j 말고 xNum, yNum 

n, m 말고 차라리 직관적인 width, height 아니면 xWidth, yHeight

근데 이렇게 하면 나만의 명명 규칙이라 다른 사람이 헷갈릴 것 같기도 하고

다른 사람들은 어떻게 하는지 찾아봐야겠다.

