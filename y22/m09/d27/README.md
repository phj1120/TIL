# 2022.09.27.

## 전력망을 둘로 나누기

[전력망을 둘로 나누기](https://school.programmers.co.kr/learn/courses/30/lessons/86971)

![](TIL-39.jpg)

n 이 작을 경우를 체크하지 않아서 숫자 제대로 카운트 못 함

```
for (int key : map.keySet()) {
    if (map.get(key).contains(now)) {
        queue.add(key);
        isVisited[key] = true;
    }
}
```

추가해도 무한 루프 발생

방향이 없는데.. 이렇게 하면 방향이 있는 것 처럼 된다....

배열 이용해서 구현해 볼까 싶다.

방문 하지 않았을 경우만 큐에 추가하는 것으로 코드를 수정해줘서 통과 했으나.

```
for (int next : map.getOrDefault(now, new ArrayList<>())) {
    if (!isVisited[next]) {
        queue.add(next);
        isVisited[next] = true;
    }
}
for (int key : map.keySet()) {
    if (!isVisited[key] && map.get(key).contains(now)) {
        queue.add(key);
        isVisited[key] = true;
    }
}
```

코드가 비효율적이라는 생각이 계속 든다.