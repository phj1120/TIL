# 2022.06.13.

## 124 나라의 숫자

효율성 문제에서 떨어진 이유규 재귀가 리소스를 많이 잡아 먹는 것이 아니라

if 가 리소스를 많이 잡아 먹어서 그랬다.

무조건 적인 if 말고 좀 더 생각해 if 를 줄이는 방향으로 코드를 짜야 겠다.

if else 를 쓰지 말자는 의견도 있다.

* 재귀

```
class Solution1 {
static StringBuilder sb = new StringBuilder();

    public String solution(int n) {
        recursive(n);
        return sb.toString();
    }

    public static void recursive(int ten) {
        if (ten == 0) return;

        int quotient = ten / 3;  // 몫
        int remainder = ten % 3;  // 나머지

        // 124 나라는 0을 표시할 수 없으므로
        if (remainder == 0) {
            quotient -= 1;
            remainder = 4;
        }

        recursive(quotient);
        sb.append(remainder);
    }
}
```

* 반복문

```
class Solution2 {
public String solution(int n) {
StringBuilder sb = new StringBuilder();
int quotient, remainder; // 몫, 나머지

        while (n != 0) {
            quotient = n / 3; // 몫
            remainder = n % 3; // 나머지

            if (remainder == 0) {
                quotient -= 1;
                remainder = 4;
            }
            n = quotient;
            sb.insert(0, remainder);
        }
        return sb.toString();
    }
}
```

## 기술 블로그

else if 를 지양 하자는 내용을 타고 타고 가다가 아래 글을 보게 되었다.

진짜 대단하다. 이런 글을 공유 해줘서 고맙다.

네카라쿠배 같은 회사에 가면 좋겠지만, 내가 과연 저 만큼의 능력을 낼 수 있을까?

바라기만 하지 말고,

할 수 있는 것을 하면서 진짜 그런 사람이 되어야 겠다.

그리고 그런 사람들은 어떻게 생각 하는지, 공부 하는 지를 보고 배워야 겠다.

AS-IS

개선 전

TO-BE

개선 후

이렇게 나눈 것이 좋았다.

[우아한 형제들 기술 블로그](https://techblog.woowahan.com/7828/)
