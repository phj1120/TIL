# 2022.05.20.

```java
package y22.m05.d20;

import java.util.Arrays;

public class Permutation {
    static int cnt = 0;

    public static void main(String[] args) {
        char[] arr = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
        System.out.println(Arrays.toString(arr));
        permutation(arr, 0, 8);
        System.out.println(Arrays.toString(arr));
        System.out.println("cnt = " + cnt);
    }

    // 순서 없이 arr.length 개 중에서 r 개를 뽑는 경우
    static void permutation(char[] arr, int depth, int r) {
        if (depth == r) {
            cnt++;
            return;
        }

        for (int i = depth; i < arr.length; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, r);
            swap(arr, depth, i); // 굳이?
        }
    }

    static void swap(char[] arr, int depth, int i) {
        char temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }
}
```

```
swap(arr, depth, i);
permutation(arr, depth + 1, r);
swap(arr, depth, i);
```

원위치 하려고 swap 을 하는 것 같은데 왜 그러지? 의문

지워도 순서만 바뀔 뿐 문제 없음

* 의문

어차피 함수마다 배열 넘겨주는 건데 원위치를 해야하나?

* 결과

객체의 경우 값을 넘겨주는 것이 아니라 값이 저장된 메모리를 가리키는 객체 변수를 넘겨 주는 것.

* 과정

```
[A, B, C, D, E, F, G, H]
[C@1b6d3586
[C@1b6d3586
[A, B, C, D, E, F, G, H]
cnt = 40320
```

아니었음 같은 배열을 공유? 하네.

당연히 값을 넘겨주는 것으로 생각하고 있었음.

char[] 가 객체니까 아 객체 변수가 넘어가는 건가?

아 그래서 프린트로 찍으면 [C@1b6d3586 이런 값이 나오고

객체 안에 있는 값을 넘겨주는 것이 아니라 객체 변수를 넘겨주는거구나.

어차피 순서가 보장이 안 되니까 원위치는 안 해도 될 듯 한데..

ㄴㄴ 해줘야함

원위치 안 한 경우
```
arr : [1, 2, 3] | depth : 3 | r : 3
arr : [1, 3, 2] | depth : 3 | r : 3
arr : [3, 1, 2] | depth : 3 | r : 3
arr : [3, 2, 1] | depth : 3 | r : 3
arr : [1, 2, 3] | depth : 3 | r : 3
arr : [1, 3, 2] | depth : 3 | r : 3
```

원위치 한 경우
```
arr : [1, 2, 3] | depth : 3 | r : 3
arr : [1, 3, 2] | depth : 3 | r : 3
arr : [2, 1, 3] | depth : 3 | r : 3
arr : [2, 3, 1] | depth : 3 | r : 3
arr : [3, 2, 1] | depth : 3 | r : 3
arr : [3, 1, 2] | depth : 3 | r : 3
```

머리속으로는 이렇게 하면 되겠다 싶긴 한데

그림으로 검증해보고 싶은데 표현하기가 어렵네
