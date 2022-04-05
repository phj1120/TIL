package y22.m03.d28;

// 람다식을 주고 받는 방법

@FunctionalInterface
interface MyFunction{
    void run();
}

public class Ex14_1 {
    static void execute(MyFunction f) { // 매개변수 타입이 MyFunction 인 메서드
        f.run();
    }

    static MyFunction getMyFunction(){ // 반환 타입이 MyFunction 인 메서드
//        참조 변수 반환
//        MyFunction f = () -> System.out.println("f3.run()");
//        return f;
        return () -> System.out.println("f3.run()");
    }

    public static void main(String[] args) {
//        람다식으로 MyFunction 의 run 을 구현
        MyFunction f1 = () -> System.out.println("f1.run()");

//        함수형 인터페이스를 직접 구현, 별 의미 없음
        MyFunction f2 = new MyFunction(){
            public void run() {
                System.out.println("f2.run()");
            }
        };

        MyFunction f3 = getMyFunction();

        f1.run();
        f2.run();
        f3.run();

        execute(f1);
        execute(() -> System.out.println("run()"));
    }
}
