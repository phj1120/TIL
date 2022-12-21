# 2022.12.21.

# 22. Generate Parentheses

[22. Generate Parentheses](https://leetcode.com/problems/generate-parentheses/)

1. (,) 을 각각 n개 씩 사용해서 만들고
2. Stack 에 넣어가며 검증

이러면 시간 초과 안나나? -> 안나기는 했는데 오래 걸리네

neetCode 풀이를 보니, 스택 하나 이용해서 풀 수 있었다.

```
if (openN < n) {
    stack.push('(');
    backtrack(openN + 1, closedN, n);
    stack.pop();
}
if (closedN < openN) {
    stack.push(')');
    backtrack(openN, closedN + 1, n);
    stack.pop();
}
```

이런식으로 고급지게 풀이 가능

새 스택을 만들어서 넘겨줄 필요 없이 넘겨줄때 push 해주고 끝날때 pop 해주면

이 작업이 끝나면 이전 상태와 동일해짐