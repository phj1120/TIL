package d220328;

public class Ex14_0 {
    public static void main(String[] args) {
//        Object obj = (a, b) -> a > b ? a : b;
        Object obj = new Object() {
            int max(int a, int b) {
                return a > b ? a : b;
            }
        };
//        int value = obj.max(3, 5); // 못써... 함수형 인터페이스 필요

        MyFunction2 f = new MyFunction2() {
            public int max(int a, int b) { // 오버라이딩 : 접근 제어자 좁게 못 바꿈
                return a > b ? a : b;
            }
        };
        int value = f.max(3, 5); // 함수형 인터페이스로 쓸 수 있음
        System.out.println("value = " + value);
    }

//    위의 것을 짧게 쓰려고 하는게 람다식

    // 람다식을 다루기 위한 참조 변수 타입 : 함수형 인터페이스로 한다. 매개변수와 반환 타입이 같아야한다.
    // -> 그럼 람다식 쓰려면 함수형 인터페이스를 계속 만들어줘야돼?
    MyFunction2 f2 = (a, b) -> a > b ? a : b;
}

@FunctionalInterface // 함수형 인터페이스 : 단 하나의 추상 메서드만 가져아함, 컴파일러가 체크
interface MyFunction2 {
    public abstract int max(int a, int b);
}