# 2022.03.28.
## 코딩 테스트 준비

복잡도 : 알고리즘의 성능을 나타내는 척도
* 시간 복잡도 : 수행 시간
* 공간 복잡도 : 메모리 사용량

빅오 표기법(Big-O Notation)
가장 빠르게 증가하는 항만 고려

3N^3 + 5N^2 + 1000000 -> O(N^3)
n이 엄청 크다고 가정하면 차수가 가장 높은 항만 의미 있지 나머지는 의미 없다.

입력, 정의, 출력 하는 것도 의미 고려 X

```
O(1)    : 상수 시간
O(logN) : 로그 시간
O(N)    : 선형 시간
O(NlogN): 로그 선형 시간
O(N^2)  : 이차 시간
O(N^3)  : 삼차 시간
O(2^n)  : 지수 시간
```

## 시간 복잡도 계산
2중 반복문
```python
array = [3, 4, 5, 6, 7]

for i in array:
    for j in array:
        temp = i * j
        print(temp)
```
시간 복잡도 O(N^2)

모든 2중 반복문이 O(N^2)인 것은 아님

내부적으로 다른 함수 호출시 그 함수의 시간 복잡도도 고려

## 알고리즘 설계 Tip
통상 1 ~ 5초 시간 제한

시간 제한(수행 시간 요구사항)을 가장 먼저 확인!

시간 제한 1초

(python 의 경우 1초에 2,000만번 연산 가능하다고 가정)
```python
* N < 500       : O(N^3) 알고리즘 설계
* N < 2,000     : O(N^2) 알고리즘 설계
* N < 100,000   : O(NlogN) 알고리즘 설계
* N < 10,000,000: O(N) 알고리즘 설계
```
많이 풀어보면서 감 잡기

## 알고리즘 문제 해결 과정
* 지문 읽기 및 컴퓨터적 사고
* 요구사항(복잡도) 분석
* 문제 해결을 위한 아이디어 찾기
* 소스 코드 설계 및 코딩

핵심 아이디어를 캐치하면 간결하게 소스코드를 작성할 수 있게 문제 출제!

그러니까 나는 간결하게 이 문제를 풀 수 있다는 마인드로 문제에 접근

소스코드는 문제를 다 풀고 마지막에 옮기는 과정

## 수행 시간 측정
```
long startTime = System.currentTimeMillis();

// 소스 코드

long endTime = System.currentTimeMillis();
System.out.println("time : " + (endTime - startTime) + " ms");
```

## 람다 표현식
함수를 간단하게 작성
틀정한 기능을 수행하는 함수를 한 줄에 작성 할 수 있음

```python
def add(a, b):
    return a + b

# 일반적
print(add(3,7))

# 람다 표현식
print((lambda a, b: a+b)(3, 7))
```

함수의 기능이 간단할 때

```python
array = [('홍길동', 50), ('이순신', 32), ('아무개', 74)]

def my_key(x):
    return x[1]

print(sorted(array, key=my_key))

# 람다 표현식
print(sorted(array, (lambda x:x[1]))
```

# JAVA의 정석 - 람다와 스트림
자바는 객체지향 언어(OOP)지만 JDK 1.8 부터 함수형 언어(FP) 기능 추가

## 람다식
함수를 간단한 식으로 표현, 익명 함수

함수 : 클래스에 독립적 / 메서드 : 클래스에 종속적

굳이 따지면 이런데 그냥 같은 의미로 알아 듣자

```
int max(int a, int b){
    return a > b ? a : b;    
}

(int a, int b) -> { return a > b ? a : b;}

(int a, int b) -> a > b ? a : b

(a, b) -> a > b ? a : b

a -> a * a

(int i) -> System.out.println(i)

```

자바에서 람다식은 익명 개체

-> 자바에서는 함수만 따로 있을 수가 없으므로

```
(a,b) -> a > b ? a : b

// 익명 클래스 선언과  익명 객체 생성을 동시에
new Object(){
    int max(int a, int b){
        return a > b ? a : b;
    }
}
```
-> 그럼 이를 다루기 위한 참조변수의 타입은?
```python
Object obj = new Object()~~

obj.max() // 불가능 Object 에 우리가 만든 max 가 없으므로
```
-> 그럼 어떻게 사용? 함수형 인터페이스!

## 함수형 인터페이스

단 하나의 추상 메서드만 선언된 인터페이스

```
interface MyFunction {
    public abstract int max(int a, int b);
}

MyFunction f = new MyFunction(){
        public int max(int a, int b){
            return a > b ? a : b;
        }
    };

int value = f.max(3, 5);
```

```
MyFunction f = (a, b) -> a > b ? a : b;

int value = f.max(3, 5);
```

## 함수형 인터페이스 타입의 매개 변수, 반환 타입
```
@FunctionalInterface
interface MyFunction{
    void myMethod();
}

void aMethod(MyFunction f){
    f.myMethod(); // MyFunction 에 정의된 메서드 호출
}
```

* 함수형 인터페이스 타입의 매개변수
```
MyFunction f = () -> System.out.println("myMethod()");
aMethod(f);

// 한번에
aMethod(() -> System.out.println("myMethod()"));

// 람다식을 메서드에 넣어주면
// 메서드 안에서 람다식을 호출해서 사용
```
람다식을 호출하기 위해 이름을 붙여주는 느낌

* 함수형 인터페이스 타입의 반환 타입
```
MyFunction myMethod(){
    MyFunction f = () -> {};
    return f;
}

MyFunction myMethod(){
    return () -> {};
}
```

자바 많이 익숙해 진 줄 알았는데 어림도 없네 

이해 안되도 꾸준히 해야겠다.