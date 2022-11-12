# 2022.11.13.

## k 번째 수

[k 번째 수](https://school.programmers.co.kr/learn/courses/30/lessons/42748)

### 부분 배열

```
int[] subArray = Arrays.copyOfRange(array, i - 1, j);
```

### 부분 리스트

subList 를 하면 새로운 리스트를 반환 하는게 아니라, 기존 리스트 값을 참조해 반환함

-> List 의 subList 만들고 subList 변경시 List 도 값이 바뀜

* AS-IS

```
List<Integer> subArray = list.subList(i - 1, j);
```

* TO-BE

```
List<Integer> subArray = new ArrayList<>(list.subList(i - 1, j));
```

[참고 자료](https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=yjw2288&logNo=221072561904)
                