# 2022.11.04.

# Summer/Winter Coding 기출 풀이

[기출 문제](https://school.programmers.co.kr/learn/challenges?order=acceptance_asc&page=1&partIds=17615%2C6174)

## Set 으로 중복 체크

Set 으로 중복값 체크 할 때, 클래스를 생성해서 비교할 경우

equals 와 hashCode 를 구현 해줘야 함

List, Set 은 이미 구현 되어 있어서 그냥 사용 가능

* 만든 클래스를 Set 에 저장할 경우

```
Set<Road> visited = new HashSet<>();
...
visited.add(new Road(nextX, nextY, nowX, nowY));
...
class Road {
    @Override
    public boolean equals(Object o) {
        ...
    }

    @Override
    public int hashCode() {
        ...
    }
}

```

* Set 에 컬렉션에 저장할 경우

```
Set<List<Integer>> visited = new HashSet<>();
...
visited.add(List.of(nextX, nextY, nowX, nowY));
```

## 자료형

### 나누기

자바에서 나누기는 정확하지 않으니까 나누기 연산을 마지막에 할 것

* AS-IS

값이 커지면 오차 발생

```
double y = (long) h / (double) w * x ; // 오차 발생
```

* TO-BE

```
double y = (long) h * x / (double) w;
```

### 곱하기

int * int 의 결과가 int 의 범위를 넘길 수 있음.

이때는 캐스팅 해서 계산

* AS-IS

```
y = h * x ; // int * int = int 지만 범위를 초과할 수 있음
```

* TO-BE

```
y = (long)h * x // long * int = long 으로 저장할 수 있는 범위 늘어남
```

## SQL

저번에 SKT 코테에서 SQL 도 이런 식으로 나와서 변수가 필요하다. 생각 했던 것 같다.

계속 삽질해 봤는데 안 돼서 답을 찾아보면서 공부했다.

SQL 공부도 꾸준히 해야겠다.