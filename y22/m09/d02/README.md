# 2022.09.02.

## 순위 검색

[순위 검색](https://school.programmers.co.kr/learn/courses/30/lessons/72412)

[강의](https://www.youtube.com/watch?v=vFwVvJQnC4M)

## 디버깅

### 일부에서 런타임 에러 발생

특별히 잘 못 된 부분 모르겠는데 stream 을 잘 못 썼나?
-> 스트림 부분 주석 -> 런타임 에러 안 생김
-> key 가 없는 null 이니까 거기서 stream 찍으면 NPE 터지니까 그럴수도 있겠다.
-> getOrDefault 이용해 기본값을 정해두고 조회

```
long count = infoMap.getOrDefault(key, new ArrayList<>()).stream()
        .filter(score -> score >= passScore)
        .count();
result[i] = (int) count;
```

### 시간 초과

stream 의 filter 로 다 돌리기엔 너무 많은가봄

-> 정렬해서 이진 탐색 하면 빠름

## 비교

equals -> == 인지 비교

객체에서 내용 비교 되도록 override 해서 사용

```
public boolean equals(Object obj) {
    return (this == obj);
}
```

Arrays.equals -> 내용이 같은지 비교

```
public static boolean equals(int[] a, int[] a2) {
        if (a==a2)
            return true;
        if (a==null || a2==null)
            return false;

        int length = a.length;
        if (a2.length != length)
            return false;

        return ArraysSupport.mismatch(a, a2, length) < 0;
    }

public static int mismatch(int[] a,
                               int[] b,
                               int length) {
        int i = 0;
        if (length > 1) {
            if (a[0] != b[0])
                return 0;
            i = vectorizedMismatch(
                    a, Unsafe.ARRAY_INT_BASE_OFFSET,
                    b, Unsafe.ARRAY_INT_BASE_OFFSET,
                    length, LOG2_ARRAY_INT_INDEX_SCALE);
            if (i >= 0)
                return i;
            i = length - ~i;
        }
        for (; i < length; i++) {
            if (a[i] != b[i])
                return i;
        }
        return -1;
    }
```

## Array to String

AS-IS

```
String key = l + " " + fi + " " + c + " " + fo;
```

TO-BE

```
String[] keyData = {l, fi, c, fo};
String key = String.join(" ", keyData);
```

