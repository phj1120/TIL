# 2022.06.05.

# 최대 공약수를 구하는 이유

나는 그냥 이렇게 깡으로 풀었는데

    // (ax, by) // x와 y가 정수인 (0, 0) 이후의 최소 값
    long ax = w, by = h;
    
    for (long i = 1; i < w; i++) {
        double y = slope * i;
        if (y - (long) y == 0) {
            ax = i;
            by = (long) y;
            break;
        }
    }

사람들 풀이를 보니까

4번 반복 되는데 보니까 이게 W와 H의 최대 공약수더라

라는 식으로 풀이 했다.

처음엔 억지 아니야? 했었는데 생각해 보니까

규칙 찾는 문제니까 이래야지 싶다.

# 최대 공약수(GCD) 구하기 - 유클리드 호제법

어떻게 쓰는지는 알겠는데 증명 봐도 모르겠음

A 와 B 의 최대 공약수를 구하려함.

A % B != 0 일 경우 A % B = C

A = B, B = C

A % B != 0 일경우 A % B = C

A = B, B = C

A % B == 0 일 경우 현재 B 값이

초기의 A와 B 의 최대 공약수.

    public int gcd(int x, int y) {
        while (true) {
            int z = x % y;
            if (z == 0) {
                return y;
            } else {
                x = y;
                y = z;
            }
        }
    }

재귀

    static public long gcd(long x, long y){
        if (x % y == 0) return y;
        return gcd(y, x%y);
    }

# 멀쩡한 사각형 개수

규칙 혼자 찾아보기...

# 큰 값 다룰 때 주의 할 점

* 곱하기 : int 와 long 의 차이

int : -2^31 ~ 2^31 까지 표현

곱하기 연산 시 곱하는 데이터의 자료형을 따라감

long answer = w * h 에서 w와 h 가 int 면 답을 구한후 int 에 저장하고 long 으로 캐스팅해 값을 넣어줌

int 의 범위보다 클 경우 오버플로우 발생할 수 있음

* 나누기

실패: floor(h / w * i);

통과: floor(h * i / w);

double 유효 자리수 53 자리 -> 이를 넘어가면 버림

나누기 후 곱하기를 할 경우 : (버려진 숫자 * 곱할 수) 만큼의 오차 발생

그렇기에 곱하기 후 나누기를 해야함.

결론 : 큰 값 연산시 long 으로 바꾸고, 나누기보다 곱하기 먼저.

* https://programmers.co.kr/questions/8705
* https://programmers.co.kr/questions/14210

# 소감

괜히 초반에는 막히면 다른 사람 풀이 보라고 한게 아닌 것 같다.

혼자 삽질하고 있었고, 생각이 여기까지 못 왔을 듯

# Reference

* https://velog.io/@guno98/프로그래머스-멀쩡한-사각형증명
* https://blog.itcode.dev/posts/2021/12/27/programmers-a0069
* https://taesan94.tistory.com/55