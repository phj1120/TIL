package y22.m05.d25;

import java.util.Date;

public class Test {

    public static void main(String[] args) {

        Date exp1 = new Date(System.currentTimeMillis() + (1000 * 60 * 60 * 24 * 21));
        Date exp2 = new Date(System.currentTimeMillis() + (1000 * 60L * 60L * 24L * 21));

        System.out.println("exp1 = " + exp1);
        System.out.println("exp2 = " + exp2);

        long long1 = (1000 * 60 * 60 * 24 * 21);
        long long2 = (1000 * 60L * 60L * 24L * 21);

        System.out.println("long1 = " + long1);
        System.out.println("long2 = " + long2);

//        long l1 = 2147483648;
//        long l2 = 2147483648L;
//
//        System.out.println("l1 = " + l1);
//        System.out.println("l2 = " + l2);

        long l1 = 1L;
        Long L1 = l1;
        int i1 = 1;
        Integer I1 = 1;

        Long R1 = L1 * I1;
//        Integer R2 = L1 * I1; // 에러

        // 작은거랑 큰거 연산하면 큰거로 가지 않나?
    }

}
