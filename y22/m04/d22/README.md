# 2022.04.22.

# 입력 한 번에 받기
```
    n = input()
    x = input()
    
    n, x = input().split()
    n = int(n)
    x = int(x)
    print(n, x)
    
    n, x = map(int, input().split())
    
    arr = list(map(int, input().split()))
```

# 정렬된 배열에서 두 특정 수의 개수 구하기

```
import bisect

n, x = map(int, input().split())
arr = list(map(int, input().split()))

print(bisect.bisect_right(arr, x) - bisect.bisect_left(arr, x))
```
라이브러리 있으니까 진짜 편하다

안쓰고 따로 구현도 해봐야겠다.


