# 2022.06.06.

최대 공약수만큼 반복,

멀쩡한 사각형의 개수 (wLong * hLong) - ((wLong + hLong) - gcd(wLong, hLong)) 개

이 규칙을 못 찾겠어서 나는 이렇게 풀었다.

다음에 문제가 나오면 당연히 최대 공약수랑 엮어서 생각할거다.

시간 복잡도도 그렇고 훨씬 간단한 풀이 인 듯하다.

전에 내가 풀이 했던 것이랑 비슷했다.

연산의 타입을 long, double 으로 맞춰주고, 연산 순서를 나누기를 마지막에 했다.

* 내 풀의

```
class Solution {
public long solution(int w, int h) {
long wLong = w, hLong = h;

        // (minX, minY) // x와 y가 정수인 (0, 0) 이후의 최소 값
        long minX = w, minY = h;

        for (int i = 1; i < w; i++) {
            double y = i * (double) hLong / (double) wLong;
            if (y - (long) y == 0) {
                minX = i;
                minY = (long) y;
                break;
            }
        }

        // 동일한 패턴 반복 횟 수
        long repeatCnt = wLong / minX;

        // 그래프 아래에 있는 칸의 개수
        long cnt = 0;
        for (int i = 0; i < wLong / repeatCnt; i++) {
            cnt += Math.ceil(i * hLong / wLong);
        }

        // 반복 되는 패턴에 빈 칸의 개수
        long partEmpty = (wLong / repeatCnt) * (hLong / repeatCnt) - 2 * cnt;

        // 전체에서 빈 칸의 개수
        long totalEmpty = partEmpty * repeatCnt;

        // 멀쩡한 사각형의 개수
        return (wLong * hLong) - totalEmpty;
    }
}
```

* 더 좋은 풀의

```
class Solution {
    public long solution(int w, int h) {
        long wLong = w, hLong = h;

        return (wLong*hLong)-((wLong+hLong)-gcd(wLong, hLong));
    }

    static public long gcd(long x, long y){
        if (x % y == 0) return y;
        return gcd(y, x%y);
    }
}
```