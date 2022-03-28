package d220328;

import java.util.*;

class MyFunc{
    int add(int a, int b) {
        return a+b;
    }
}

// 함수형 언어에서는 람다식을 익명 함수로 사용.
// 근데 객체 지향 언어에서는 함수만 존재 할 수 없고
// 클래스에 종속되어 메서드로 존재
// 그래서 함수형 인터페이스로 익명 객체 생성
@FunctionalInterface
interface MyInter{
    int add(int a, int b);
}

public class LambdaPrac {
    public static void main(String[] args) {
        MyFunc f1 = new MyFunc();
        System.out.println(f1.add(1, 2));

        MyInter i = (a, b) -> a + b;
        System.out.println(i.add(1, 2));


//        Collections.sort(List list, Comparator c)
//        sort 하기 위해서는 Comparator 필요한데
//        자바는 메서드만 존재 못해... 객체 생성 필요
        List<String> list = Arrays.asList("abc", "aaa", "bbb", "ddd", "aaa");
        System.out.println("list 정렬 전 : "+list);
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println("list 정렬 후 : "+list);

//        자주 사용되는 함수형 인터페이스 java.util.function 패키지에 정의 되어 있음
//        @FunctionalInterface
//        interface Comparator<T> {
//            int compare(T o1, T o2);
//        }

//        이렇게 람다식으로 구현 할 수 있다.
        List<String> list2 = Arrays.asList("abc", "aaa", "bbb", "ddd", "aaa");
        System.out.println("list2 정렬 전 : "+list2);

        Collections.sort(list2, (s1, s2) -> s2.compareTo(s1));
        System.out.println("list2 내림 차순 : "+list2);

        Collections.sort(list2, (s1, s2) -> s1.compareTo(s2));
        System.out.println("list2 오름 차순 : "+list2);

    }
}
