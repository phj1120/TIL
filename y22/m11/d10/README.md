# 2022.11.10.

# 코딩 테스트 연습

[코딩 테스트 연습](https://school.programmers.co.kr/learn/courses/30/lessons/118668)

오전 내내, 오후에 짬짬히 풀었다.

시간이 오래 걸린 이유는

조건을 잘 못 줬는데 전체적인 로직이 잘 못된건가 보고 있었기 때문이다.

AS-IS

```
if (requiredAlgorithmStat <= a && requiredCodingStat <= c) {
```

TO-BE

```
if (requiredAlgorithmStat <= a && c <= requiredCodingStat) {
```
